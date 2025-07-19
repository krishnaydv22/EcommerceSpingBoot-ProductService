package com.ecomApp.ecomApp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductWihCategoryDto {

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private long id;
    private String title;
    private long categoryId;
    private String brand;
    private boolean popular;

    private CategoryDto category;

}
