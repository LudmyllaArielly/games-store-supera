package com.game.store.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.store.model.Product;
import com.game.store.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findByCode(Integer code) {
		Product product = productRepository.findByCode(code);
		return product;
	}

	@Override
	public List<Product> productOrderByPrice() {
		List<Product> products = productRepository.findAll()
				.stream().sorted(Comparator.comparing(Product::getPrice))
				.collect(Collectors.toList());
		return products;
	}

	@Override
	public List<Product> productOrderByScore() {
		List<Product> products = productRepository.findAll()
				.stream().sorted(Comparator.comparing(Product::getScore))
				.collect(Collectors.toList());
		return products;
	}

	@Override
	public List<Product> productOrderAlphabetical() {
		List<Product> product = new ArrayList<Product>(productRepository.findAll());
		product.sort(Comparator.comparing(Product::getName));
		
		return product;
	}
}
