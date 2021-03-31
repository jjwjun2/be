package com.example.demo.pay.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class PaymentDto {
    private Long payNo;
    private String payPrice;
    private Long payAmount;
    private String dvrFee;
    private String payDate;
    private String payState;
}