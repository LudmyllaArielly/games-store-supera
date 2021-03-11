package com.game.store.model.dto;

import java.io.Serializable;
import java.util.List;

public class CartUpdateDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private List<CartItemsAddedProductDTO> cartItemsAddedProductDTOs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartItemsAddedProductDTO> getCartItemsAddedProductDTOs() {
		return cartItemsAddedProductDTOs;
	}

	public void setCartItemsAddedProductDTOs(List<CartItemsAddedProductDTO> cartItemsAddedProductDTOs) {
		this.cartItemsAddedProductDTOs = cartItemsAddedProductDTOs;
	}
	
	
}
