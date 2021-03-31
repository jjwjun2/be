package com.example.demo.prd.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;


import com.example.demo.prd.domain.Product;
import com.example.demo.prd.repository.ProductRepositoy;

import lombok.RequiredArgsConstructor;



@Service 
@RequiredArgsConstructor
public class ProductServiceImpl {
	@Autowired ProductRepositoy productMapper;
	public int add(Product prd) {
	return productMapper.insert(prd);}
	
	public int update(Product prd) {
	return productMapper.update(prd);}

	public int delete(Product prd) {
	return productMapper.delete(prd);}
	
}
