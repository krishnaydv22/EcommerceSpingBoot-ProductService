package com.ecomApp.ecomApp.mappers;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.CategoryWithProductDto;
import com.ecomApp.ecomApp.entity.Category;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDto toDto(Category cat){
        return CategoryDto.builder()
                .id(cat.getId())
                .name(cat.getName()).build();
    }

    public static Category toEntity(CategoryDto dto){
       return Category.builder()
                .name(dto.getName()).build();

    }

    public static CategoryWithProductDto categoryWithProductDto(Category category){
        return CategoryWithProductDto.builder()
                .id(category.getId())
                .name(category.getName())
                .productDto(category.getProducts().stream()
                        .map(ProductMapper::toDto).collect(Collectors.toList()))
                .build();

    }


}
