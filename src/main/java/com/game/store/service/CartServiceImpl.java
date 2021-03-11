package com.game.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.game.store.model.Cart;
import com.game.store.model.CartItems;
import com.game.store.model.enums.Status;
import com.game.store.repository.CartRepository;
import com.game.store.useful.Useful;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemsService cartItemsService;

	@Override
	public Long addItems(Cart cart) {
		List<CartItems> cartItems = cartItemsService.addItemsToCart(cart.getCartItems());
		cart.setCartItems(cartItems);
		cart.setTotal(totalPriceOfCartItems(cart));
		cart.setShipping(returnsTheShipping(cart));
		cart.setStatus(Status.OPEN);
		Cart cartCreated = cartRepository.save(cart);
		return cartCreated.getId();
	}

	private Double totalPriceOfCartItems(Cart cart) {
		Double total = 0.0;
		Double subtotal = 0.0;
		for (int i = 0; i < cart.getCartItems().size(); i++) {
			subtotal = cart.getCartItems().get(i).getSubtotal();
			total += subtotal;
		}
		return Useful.roundsValue(total);
	}

	private Double returnsTheShipping(Cart cart) {
		Double priceTotalOfCart = cart.getTotal();
		Double shipping = 10.00;
		Double totalShipping = 0.0;
		int quantity = cart.getCartItems().size();
		totalShipping = quantity * shipping;
		if (priceTotalOfCart > 250.00) {
			totalShipping = 0.0;
		}
		return totalShipping;
	}

	@Override
	@Transactional
	public List<Cart> listAllCart() {
		List<Cart> carts = new ArrayList<Cart>();
		List<Cart> list = cartRepository.findAll();
		list.forEach(carts::add);
		return list;
	}

	@Override
	@Transactional
	public Optional<Cart> findByCart(Long id) {
		Optional<Cart> cart = cartRepository.findById(id);
		return cart;
	}

	@Transactional
	@Modifying
	@Override
	public void checkoutCart(Cart cart) {
		Optional<Cart> cartId = cartRepository.findById(cart.getId());
		cart.setCartItems(cartId.get().getCartItems());
		cart.setTotal(cartId.get().getTotal());
		cart.setShipping(cartId.get().getShipping());
		cart.setCode(cartId.get().getCode());
		cartRepository.save(cart);
	}

	@Override
	public void removeItems(Long idCart, Long idCartItems) {
		Optional<Cart> cart = cartRepository.findById(idCart);
		for (int i = 0; i < cart.get().getCartItems().size(); i++) {
			List<CartItems> cartItems = cart.get().getCartItems();
			if (idCartItems.equals(cartItems.get(i).getId())) {
				cart.get().getCartItems().remove(i);
				cartItemsService.removeItems(idCartItems);
				updatesTheCartAfterTheItemIsRemoved(idCart);
			}
		}
	}

	@Transactional
	@Modifying
	private void updatesTheCartAfterTheItemIsRemoved(Long idCart) {
		Optional<Cart> cart = cartRepository.findById(idCart);
		Cart carts = cart.get();
		carts.setTotal(totalPriceOfCartItems(carts));
		carts.setShipping(returnsTheShipping(carts));
		cartRepository.save(carts);
	}

	@Transactional
	@Modifying
	@Override
	public void addMoreItems(Cart cart) {
		Cart carts = getCart(cart);
		List<CartItems> item = carts.getCartItems();
		checksIfTheItemAlreadyExits(cart);
		List<CartItems> cartItem = cartItemsService.addItemsToCart(cart.getCartItems());
		item.addAll(cartItem);

		cart.setCartItems(item);
		cart.setTotal(totalPriceOfCartItems(cart));
		cart.setShipping(returnsTheShipping(carts));
		cart.setStatus(Status.OPEN);
		cart.setCode(carts.getCode());
		cartRepository.save(cart);
	}

	private void checksIfTheItemAlreadyExits(Cart cart) {
		Cart carts = getCart(cart);
		Integer cartItems = 0;
		cartItems = cart.getCartItems().get(0).getProduct().getCode();

		for (int i = 0; i < carts.getCartItems().size(); i++) {
			Integer cartItemsCode = carts.getCartItems().get(i).getProduct().getCode();
			Integer newCartItemCode = cartItems;

			if (newCartItemCode.equals(cartItemsCode)) {
				throw new IllegalArgumentException("Item already exists in the cart.");
			}
		}
	}

	private Cart getCart(Cart cart) {
		Optional<Cart> cartOptional = cartRepository.findById(cart.getId());
		Cart carts = cartOptional.get();
		return carts;
	}

}
