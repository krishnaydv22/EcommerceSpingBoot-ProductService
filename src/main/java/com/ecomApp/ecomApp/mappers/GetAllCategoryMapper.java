package com.ecomApp.ecomApp.mappers;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.FakeStoreCategoryResponseDto;

import java.util.List;

public class GetAllCategoryMapper {

    public static FakeStoreCategoryResponseDto toFakeStoreCategoryDTO(){
        return null;
    }

    public static List<CategoryDto> toCategoryDto(FakeStoreCategoryResponseDto dto){
        return dto.getCategories().stream().map(
                category -> CategoryDto.builder().name(category).build())
                .toList();

    }
}
