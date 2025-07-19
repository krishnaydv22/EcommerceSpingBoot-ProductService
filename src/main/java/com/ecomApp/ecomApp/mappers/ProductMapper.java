package com.ecomApp.ecomApp.mappers;

import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.dto.ProductWihCategoryDto;
import com.ecomApp.ecomApp.entity.Category;
import com.ecomApp.ecomApp.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product prod){
        return ProductDto.builder()
                .id(prod.getId())
                .image(prod.getImage())
                .color(prod.getColor())
                .brand(prod.getBrand())
                .price(prod.getPrice())
                .title(prod.getTitle())
                .model(prod.getModel())
                .description(prod.getDescription())
                .discount(prod.getDiscount())
                .popular(prod.isPopular())
                .categoryId(prod.getCategory().getId())
                .build();


    }

    public static Product toEntity(ProductDto dto, Category category){


        return Product.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .title(dto.getTitle())
                .model(dto.getModel())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .popular(dto.isPopular())
                .category(category)
                .build();
    }

    public static ProductWihCategoryDto toProductWihCategoryDto(Product prod){

        return ProductWihCategoryDto.builder()
                .id(prod.getId())
                .image(prod.getImage())
                .color(prod.getColor())
                .brand(prod.getBrand())
                .price(prod.getPrice())
                .title(prod.getTitle())
                .model(prod.getModel())
                .description(prod.getDescription())
                .discount(prod.getDiscount())
                .popular(prod.isPopular())
                .category(CategoryMapper.toDto(prod.getCategory()))
                .build();



    }

}
