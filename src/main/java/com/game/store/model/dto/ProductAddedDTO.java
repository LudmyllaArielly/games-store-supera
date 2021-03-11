package com.game.store.model.dto;

import java.io.Serializable;

public class ProductAddedDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
