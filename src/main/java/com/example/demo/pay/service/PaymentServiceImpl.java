package com.example.demo.pay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.pay.domain.Payment;
import com.example.demo.pay.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl extends AbstractService<Payment> implements PaymentService {
	private final PaymentRepository repo;

	@Override
	public long save(Payment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long delete(Payment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Payment getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Payment> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}