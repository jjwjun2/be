package com.example.demo.brd.domain;


import javax.persistence.Column;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class BoardDto {
	 private Long brdNo;
	 private String  brdTitle;
	 private String brdContent;
	 private String brdWrtDate;
	 private String brdRank;
	 private String brdImg;
	 private Long brdKind;
	 private String brdModDate;
	 private Long count;
	 private String brdLike;
	 private String brdPwd;
	 private String usrNickname;
}
