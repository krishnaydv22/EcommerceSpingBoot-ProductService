package com.ecomApp.ecomApp.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryWithProductDto {
    private long id;
    private String name;

    private List<ProductDto> productDto;

}
