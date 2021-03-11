package com.game.store.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.store.mapper.CartMapper;
import com.game.store.model.Cart;
import com.game.store.model.dto.CartAddItemsDTO;
import com.game.store.model.dto.CartCheckoutDTO;
import com.game.store.model.dto.CartUpdateDTO;
import com.game.store.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartResource {

	@Autowired
	private CartService cartService;

	@PostMapping
	public ResponseEntity<String> addItems(@RequestBody CartAddItemsDTO cartAddItemsDTO) {
		try {
			Cart cart = CartMapper.INSTANCE.toCartAddItemsDTO(cartAddItemsDTO);
			cartService.addItems(cart);
			return ResponseEntity.status(HttpStatus.CREATED).body("Success when adding items to the cart. ");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Failed to add items to the cart: " + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<List<Cart>> listAllCart() {
		try {
			List<Cart> carts = cartService.listAllCart();
			return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<Cart>>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cart>> findByCart(@PathVariable("id") Long id) {
		try {
			Optional<Cart> cart = cartService.findByCart(id);
			return new ResponseEntity<Optional<Cart>>(cart, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Optional<Cart>>(HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> checkout(@RequestBody CartCheckoutDTO cartCheckoutDTO) {
		try {
			Cart cart = CartMapper.INSTANCE.toCartCheckoutDTO(cartCheckoutDTO);
			cartService.checkoutCart(cart);
			return ResponseEntity.status(HttpStatus.OK).body("Checkout success. ");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Failed to checkout: " + e.getMessage());
		}
	}

	@DeleteMapping
	public ResponseEntity<String> removeItems(Long idCart, Long idCartItems) {
		try {
			cartService.removeItems(idCart, idCartItems);
			return ResponseEntity.status(HttpStatus.OK).body(" Success removing items.");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Failed to remove items: " + e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> addMoreItems(@RequestBody CartUpdateDTO cartUpdateDTO) {
		try {
			Cart cart = CartMapper.INSTANCE.toCartUpdateDTO(cartUpdateDTO);
			cartService.addMoreItems(cart);
			return ResponseEntity.status(HttpStatus.OK).body("Success adding items.");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add items: " + e.getMessage());
		}

	}

}
