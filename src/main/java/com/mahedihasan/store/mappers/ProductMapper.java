package com.mahedihasan.store.mappers;

import com.mahedihasan.store.dtos.ProductDto;
import com.mahedihasan.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
}
