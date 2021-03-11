package com.game.store.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.game.store.model.CartItems;
import com.game.store.model.dto.CartItemsAddedProductDTO;
import com.game.store.model.dto.CartItemsIdDTO;

@Mapper(uses = {ProductMapper.class})
public interface CartItemsMapper {
	
	CartItemsMapper INSTANCE = Mappers.getMapper(CartItemsMapper.class);
	
	@Mappings({
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "product", source = "productAddedDTO"),
		@Mapping(target = "subtotal", ignore = true)
	})
	CartItems toCartItemsAddedProductDTO(CartItemsAddedProductDTO source);
	
	@Mappings({
		@Mapping(target = "product", ignore =true),
		@Mapping(target = "subtotal", ignore = true),
		@Mapping(target = "quantity", ignore = true)
	})
	CartItems toCartItemsIdDTO(CartItemsIdDTO source);
}
