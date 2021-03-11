package com.game.store.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.game.store.model.Cart;
import com.game.store.model.dto.CartAddItemsDTO;
import com.game.store.model.dto.CartCheckoutDTO;
import com.game.store.model.dto.CartUpdateDTO;

@Mapper(uses = {CartItemsMapper.class})
public interface CartMapper {
	CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
	
	@Mappings({
		@Mapping(target = "cartItems", source = "cartItemsAddedProductDTOs" ),
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "shipping", ignore = true),
		@Mapping(target = "total", ignore = true)
	})
	Cart toCartAddItemsDTO(CartAddItemsDTO source);
	
	@Mappings({
		@Mapping(target = "cartItems", ignore = true ),
		@Mapping(target = "shipping", ignore = true),
		@Mapping(target = "total", ignore = true),
		@Mapping(target = "code", ignore = true)
		
	})
	Cart toCartCheckoutDTO(CartCheckoutDTO source);
	

	@Mappings({
		@Mapping(target = "cartItems", source="cartItemsAddedProductDTOs"),
		@Mapping(target = "shipping", ignore = true),
		@Mapping(target = "total", ignore = true),
		@Mapping(target = "status", ignore = true),
		@Mapping(target = "code", ignore = true)
	})
	Cart toCartUpdateDTO (CartUpdateDTO source);
}

