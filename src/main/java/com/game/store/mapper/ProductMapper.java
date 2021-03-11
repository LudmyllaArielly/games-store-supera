package com.game.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.game.store.model.Product;
import com.game.store.model.dto.ProductAddedDTO;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	@Mappings({
		@Mapping(target = "id",ignore = true),
		@Mapping(target = "name",ignore = true),
		@Mapping(target = "image",ignore = true),
		@Mapping(target = "score",ignore = true),
		@Mapping(target = "price",ignore = true),
	})
	Product toProductAddedDTO(ProductAddedDTO source);
}