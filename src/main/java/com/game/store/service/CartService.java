package com.game.store.service;

import java.util.List;
import java.util.Optional;

import com.game.store.model.Cart;

public interface CartService {

	Long addItems(Cart cart);

	List<Cart> listAllCart();

	Optional<Cart> findByCart(Long id);

	void checkoutCart(Cart cart);

	void removeItems(Long idCart, Long idCartItems);

	void addMoreItems(Cart cart);
}
