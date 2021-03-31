package com.example.demo.cart.domain;

import javax.persistence.Column;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class CartDto {
	private int cartNo;
	private int cartAmount;
}
