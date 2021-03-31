package com.example.demo.usr.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.PersistenceContext;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.enm.Swear;
import com.example.demo.cmm.service.AbstractService;
import com.example.demo.usr.domain.EncryptionUtils;
import com.example.demo.usr.domain.MailDto;
import com.example.demo.usr.domain.User;
import com.example.demo.usr.domain.UserDto;
import com.example.demo.usr.repositoy.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl extends AbstractService<User> implements UserService {
	private final UserRepository userRepository;
	private JavaMailSender mailSender;
	
	

	@Override
	public long save(User user) {
		return userRepository.save(user) != null ? 1 : 0;
	}
	
	@Override
	public boolean checkDuplicateId(String userId) {
		if (userId != null) {
			return userRepository.checkId(userId);
		}
		return false;
	}

	@Override
	public boolean checkDuplicateEmail(String userId) {
		if (userId != null) {
			return userRepository.findByEmail(userId);
		}
		return false;
	}

	public boolean userEmailCheck(String userEmail, String userName) {
		
		
		if (userEmail != null && userName != null) {
			Optional<User> findUser = userRepository.findUserByEmail(userEmail);
			return findUser.isPresent() && findUser.get().getUsrName().equals(userName) ? true : false;
		}
		return false;
	}

	public long login(User user) { return 3; }

	@Override
	public List<User> findUsersByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public String findIdByEmail(String userEmail) {
		if (userEmail != null) {
			return userRepository.findIdByEmail(userEmail);
		}
		return "";
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAllUser();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll().stream().sorted(Comparator.comparing(User::getUsrName).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public Optional<User> updateProfile(User user) {
		return userRepository.updateProfile(user.getUsrEmail(), user.getUsrPwd());
	}

	@Override
	public long delete(User user) {
		userRepository.delete(user);
		return getOne(user.getUsrNo()) != null ? 1 : 0;
	}
	
	
	
	
	
	
	
	/**				 
	 * 
	 *  회원가입 Logic
	 *  
	 * */
	
//	@Override
//	public boolean idFormatCheck(String id) {
//		String reg = "^[a-zA-Z0-9][\\w]{7,17}$";
//		return Pattern.compile(reg).matcher(id).matches();
//	}
//	
//	@Override
//	public boolean mailFormatCheck(String email) {
//		String reg = "^[a-zA-Z0-9]*[\\w-]{4,17}$";
//		return Pattern.compile(reg).matcher(email).matches() ? true : false;
//	}
//
//	@Override
//	public boolean nickNameFormatCheck(String nickName) {
//		String reg = "^[\\w가-힣]{2,15}$";
//		return Pattern.compile(reg).matcher(nickName).matches() ? true : false;
//	}

//	@Override
//	public boolean phoneFormatCheck(String phone) {
//		String reg = "[^0-9a-zA-Z])(01[0|1|6|7|8|9][\\s-:\\.]?)(\\d{3,4}[\\s-:\\.]?)(\\d{4})(?=[^0-9a-zA-Z])$";
//		return Pattern.compile(reg).matcher(phone).matches() ? true : false;
//	}

//	@Override
//	public boolean nameFormatCheck(String usrName) {
//		String reg = "^[a-zA-Z가-힣]{2,12}$";
//		return Pattern.compile(reg).matcher(usrName).matches() ? true : false;
//	}
	
	
	
	@Override
	public void updatePassword(String str, String userEmail) {
		String pw = EncryptionUtils.encryptMD5(str);
		String id = userRepository.findIdByEmail(userEmail);
		userRepository.updateUserPassword(id, pw);
	}

	@Override
	public String createTempPassword() {
		Random random = new Random();
		return IntStream.iterate(0, i -> (char) (random.nextInt('Z' - 'A') + 'A')).limit(10)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}


	@Override
	public MailDto createMailAndChangePassword(String userEmail, String userName) {
		if (userEmail != null && userName != null) {
			String str = createTempPassword();
			MailDto mailDto = new MailDto();
			mailDto.setAddress(userEmail);
			mailDto.setTitle(String.format("%s님의 임시비밀번호 관련 메일입니다.", userName));
			mailDto.setMessage(String.format("안녕하세요 %s님. 임시비밀번호 안내 관련 이메일입니다. 고객님의 임시 비밀번호는 %s 입니다.", userName, str));
			updatePassword(str, userEmail);
			return mailDto;
		}
		return null;
	}

	
	@Override
	public void mailSend(MailDto mailDto) {
		System.out.println("이멜 전송 완료!");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDto.getAddress());
		message.setFrom("jjwjun10@gmail.com");
		message.setSubject(mailDto.getTitle());
		message.setText(mailDto.getMessage());
		mailSender.send(message);
	}
	
	public Map<?, ?> userDetail(UserDto usrDto) {
		var map = new HashMap<>();
		return map;
	}

	
	@Override public UserDto create(UserDto user) { return null; }
	@Override public User getOne(long id) { return userRepository.getOne(id); }
	@Override public long count() { return 0; }
	@Override public Optional<User> findById(long id) {	return null; }
	@Override public boolean existsById(long id) { return false; }
	@Override public boolean emailCheck(User user) { return false; }
	@Override public boolean idCheck(User user) { return false; }


	@Override
	public boolean swearFilter(String word) {
		if (word != null) {
			String reg = String.format("^[\\w가-힣\\s]*%s[\\s\\w가-힣\\s]*$", word);
			return Swear.KOREAN_SWEAR_LIST.getSwearList().stream()
					.anyMatch(x -> Pattern.compile(reg).matcher(word).matches());
		}
		return false;
	}

}