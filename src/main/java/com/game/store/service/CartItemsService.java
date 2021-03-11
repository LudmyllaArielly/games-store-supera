package com.game.store.service;

import java.util.List;
import java.util.Optional;

import com.game.store.model.CartItems;

public interface CartItemsService {

	List<CartItems> addItemsToCart(List<CartItems> cartItems);

	void removeItems(Long id);

	Optional<CartItems> findById(Long id);

}
