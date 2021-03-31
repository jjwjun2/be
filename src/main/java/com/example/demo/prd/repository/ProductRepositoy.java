package com.example.demo.prd.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.prd.domain.Product;


public interface ProductRepositoy {

	public List<Product> selectAll();
//	public int insert(Product prd);
//	public List<Product> selectAll();
//	public Product selectById(int prdId);
//	public int update(Product prd);
//	public int delete(Product prd);

	public Product selectById(int prdId);

	public int insert(Product prd);

	public int update(Product prd);

	public int delete(Product prd);
}
