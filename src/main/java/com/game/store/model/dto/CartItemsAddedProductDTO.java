package com.game.store.model.dto;

import java.io.Serializable;

public class CartItemsAddedProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double quantity;
	private ProductAddedDTO productAddedDTO;

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public ProductAddedDTO getProductAddedDTO() {
		return productAddedDTO;
	}

	public void setProductAddedDTO(ProductAddedDTO productAddedDTO) {
		this.productAddedDTO = productAddedDTO;
	}

}
