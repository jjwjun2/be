package com.example.demo.brd.domain;

import javax.persistence.Column;

//@NamedQuery(
//name = "Board.findByBrdTitle",
//query = "select b from Board b where b.brdTitle like :brdTitle")
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.demo.pay.domain.Payment;
import com.example.demo.prd.domain.Product;
import com.example.demo.rpl.domain.Reply;
import com.example.demo.usr.domain.User;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Board {
	@Id @Column(name="brd_no") @GeneratedValue(strategy = GenerationType.IDENTITY) private Long brdNo;
	@Column(name="brd_Title") private String  brdTitle;
	@Column(name="brd_content") private String brdContent;
    @Column(name="brd_wrt_date") private String brdWrtDate;
    @Column(name="brd_rank") private String brdRank;
    @Column(name="brd_img") private String brdImg;
    @Column(name="usr_nickname") private String usrNickname;
    @Column(name="brd_kind") private Long brdKind;
    @Column(name="brd_count") private Long count;
    @Column(name="brd_like") private String brdLike;
    @Column(name="brd_pwd") private String brdPwd;
   
   
    @OneToMany(mappedBy="board")	
    private List<Reply> replyList = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="usr_no")
    private User user;
   
    @ManyToOne
    @JoinColumn(name="pay_no")
    private Payment payment;
    
    @ManyToOne
    @JoinColumn(name="prd_no")
    private Product product;
    // 분해 : 정규화
    // 반대 : 역정규화
    
   
}