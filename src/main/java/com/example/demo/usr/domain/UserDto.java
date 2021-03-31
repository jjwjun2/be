package com.example.demo.usr.domain;

import java.util.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Component
@Lazy
@Getter
@NoArgsConstructor
public class UserDto {

	private static final long serialVersionUID = 1L;
	private Long usrNo;

	@Size(min = 2, max = 8, message = "이름을 2~8자 사이로 입력해주세요.")
	private String usrName;

//	@NotBlank(message = "반드시 입력해야하는 칸입니다.")
//	@Email(message = "이메일 형식에 맞지 않습니다.")
	private String usrEmail;

//	@NotBlank(message = "패스워드는 필수 입력 값입니다.")
//	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{6,12}", message = "비밀번호는 영문자와 숫자, 특수기호가 적어도 1개 이상 포함된 6자~12자의 비밀번호여야 합니다.")
	private String usrPwd;
	private String usrAges;
	private String usrCity;
	private String usrGender;
	private String usrPhone;
	private String usrAddr;
	private String usrNickname;
	private String usrId;

	@Builder
	public UserDto(String usrName, String usrEmail, String usrPwd, String usrPhone, String usrNickname) {
		super();
		this.usrName = usrName;
		this.usrEmail = usrEmail;
		this.usrPwd = usrPwd;
		this.usrPhone = usrPhone;
		this.usrNickname = usrNickname;
	}

	public UserDto(String usrEmail, String usrNickname) {
		this.usrEmail = usrEmail;
		this.usrNickname = usrNickname;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDto that = (UserDto) o;
		return Objects.equals(usrNo, that.usrNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usrNo);
	}

	@Override
	public String toString() {
		return "UserDto [usrNo=" + usrNo + ", usrName=" + usrName + ", usrEmail=" + usrEmail + ", usrPwd=" + usrPwd
				+ ", usrAges=" + usrAges + ", usrCity=" + usrCity + ", usrGender=" + usrGender + ", usrPhone="
				+ usrPhone + ", usrAddr=" + usrAddr + ", usrNickname=" + usrNickname + ", usrId=" + usrId + "]";
	}

}