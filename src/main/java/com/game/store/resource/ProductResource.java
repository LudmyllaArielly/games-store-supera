package com.game.store.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.store.model.Product;
import com.game.store.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping("/orderbyprice")
	public ResponseEntity<List<Product>> productOrderByPrice() {
		try {
			List<Product> products = productService.productOrderByPrice();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/orderbyscore")
	public ResponseEntity<List<Product>> productOrderByScore() {
		try {
			List<Product> products = productService.productOrderByScore();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<Product>> productOrderAlphabetical() {
		try {
			List<Product> products = productService.productOrderAlphabetical();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}

}
