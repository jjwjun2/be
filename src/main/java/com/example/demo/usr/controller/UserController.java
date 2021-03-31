package com.example.demo.usr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.cmm.controller.AbstractController;
import com.example.demo.usr.domain.*;
import com.example.demo.usr.repositoy.UserRepository;
import com.example.demo.usr.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usr")
public class UserController extends AbstractController<User> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final UserRepository userRepository;
	private final UserServiceImpl userService;
	
//	@PostMapping("/user/sendSignUpEmail")
//	public String sendSignUpEmail(@ModelAttribute @Valid Account account, BindingResult errors, Model model) throws DuplicateEmailException, SendEmailException{
//        if (errors.hasErrors()) {
//            Map<String, String> validatorResult = accountSecurityService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//            }
//            return "/user/register";
//        }
	
	
	@PostMapping("/save")
	public ResponseEntity<Long> save(@RequestBody User user) {
		logger.info("User Register: " + user.toString());
		return ResponseEntity.ok(userService.save(user));
	}

	@PostMapping("/login")
	public ResponseEntity<Long> login(@RequestBody User user) {
		logger.info("Login user" + user.toString());
		return ResponseEntity.ok(userService.login(user));
	}

	@GetMapping("/find/{name}")
	public ResponseEntity<List<User>> findByName(@RequestBody User user) {
		logger.info("Find user by name: " + user.getUsrName());
		return ResponseEntity.ok(userService.findUsersByName(user.getUsrName()));
	}

//	// 2.Read(3) - 비밀번호 찾기(로그인 시)
//	@GetMapping("/find/{password}")
//	public ResponseEntity<Optional<User>> findPassword(@RequestBody User user) {
//		logger.info("Find password:" + user.toString());
//		return ResponseEntity.ok(userService.findPassword(user.getUsrPwd()));
//	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll() {
		logger.info("Find all users.");
		return ResponseEntity.ok(userService.findAll());
	}

	@PostMapping("/update/profile")
	public ResponseEntity<Optional<User>> updateProfile(@RequestBody User user) {
		logger.info("Update user profile: " + user.toString());
		return ResponseEntity.ok(userService.updateProfile(user));
	}
	
	@PostMapping("/update/password")
	public ResponseEntity<Optional<User>> updatePassword(@RequestBody User user) {
		logger.info("Update user profile: " + user.toString());
		return ResponseEntity.ok(userService.updateProfile(user));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody User user) {
		logger.info("Delete user :" + user.toString());
		return ResponseEntity.ok(userService.delete(user));
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<User> getOne(@PathVariable long id) {
		return ResponseEntity.ok(userService.getOne(id));
	}

	@GetMapping("/check/findPw")
	public @ResponseBody Map<String, Boolean> passwordFind(@RequestBody User user) {
		Map<String, Boolean> map = new HashMap<>();
		boolean userCheck = userService.userEmailCheck(user.getUsrEmail(), user.getUsrName());
		logger.info("Match(Email, Name) : " + userCheck);
		map.put("check", userCheck);
		return map;
	}

	
	@PostMapping("/check/findPw/sendEmail")
	public @ResponseBody void sendEmail(@RequestBody User user) {
		MailDto dto = userService.createMailAndChangePassword(user.getUsrEmail(), user.getUsrName());
		userService.mailSend(dto);
		logger.info("Send temporary password");
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		logger.info("Query total count.");
		return ResponseEntity.ok(userService.count());
	}
	
	@Override public ResponseEntity<Optional<User>> findById(long id) { return null; }
	@Override public ResponseEntity<Boolean> existsById(long id) { return null; }

}