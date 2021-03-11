package com.game.store.service;

import java.util.List;

import com.game.store.model.Product;

public interface ProductService {

	Product findByCode(Integer code);

	List<Product> productOrderByPrice();

	List<Product> productOrderByScore();
	
	List<Product> productOrderAlphabetical();

}
