package com.example.demo.pay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.controller.AbstractController;
import com.example.demo.pay.domain.Payment;
import com.example.demo.pay.service.PaymentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/payment")
public class PaymentController extends AbstractController<Payment> {
	final PaymentServiceImpl paymentServiceImpl;

	@Override
	public ResponseEntity<Long> save(Payment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Long> count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Payment>> findAll() {
		return null;
	}

	@Override
	public ResponseEntity<Long> delete(Payment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Payment> getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<Payment>> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Boolean> existsById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}