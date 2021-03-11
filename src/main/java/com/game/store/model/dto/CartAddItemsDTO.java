package com.game.store.model.dto;

import java.io.Serializable;
import java.util.List;

import com.game.store.model.enums.Status;

public class CartAddItemsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private Status status;
	private List<CartItemsAddedProductDTO> cartItemsAddedProductDTOs;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<CartItemsAddedProductDTO> getCartItemsAddedProductDTOs() {
		return cartItemsAddedProductDTOs;
	}

	public void setCartItemsAddedProductDTOs(List<CartItemsAddedProductDTO> cartItemsAddedProductDTOs) {
		this.cartItemsAddedProductDTOs = cartItemsAddedProductDTOs;
	}

}
