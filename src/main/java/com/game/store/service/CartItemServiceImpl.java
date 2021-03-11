package com.game.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.store.model.CartItems;
import com.game.store.model.Product;
import com.game.store.repository.CartItemsRepository;
import com.game.store.useful.Useful;

@Service
public class CartItemServiceImpl implements CartItemsService {

	@Autowired
	private CartItemsRepository cartItemsRepository;

	@Autowired
	private ProductService productService;

	@Override
	public List<CartItems> addItemsToCart(List<CartItems> cartItems) {
		for (int i = 0; i < cartItems.size(); i++) {
			Product products = productService.findByCode(cartItems.get(i).getProduct().getCode());

			Double quantity = cartItems.get(i).getQuantity();
			Double price = products.getPrice();
			Double subtotal = quantity * price;

			cartItems.get(i).setProduct(products);
			cartItems.get(i).setSubtotal(Useful.roundsValue(subtotal));
			cartItems.get(i).setQuantity(quantity);
		}
		List<CartItems> item = cartItemsRepository.saveAll(cartItems);
		return item;
	}

	@Override
	public void removeItems(Long id) {
		Optional<CartItems> cartItems = cartItemsRepository.findById(id);
		CartItems items = cartItems.get();
		cartItemsRepository.delete(items);
	}

	@Override
	public Optional<CartItems> findById(Long id) {
		Optional<CartItems> items = cartItemsRepository.findById(id);
		return items;
	}

}
