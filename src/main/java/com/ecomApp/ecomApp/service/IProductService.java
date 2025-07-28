package com.ecomApp.ecomApp.service;

import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.dto.ProductWihCategoryDto;

public interface IProductService {
    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto dto) throws Exception;

   ProductWihCategoryDto getProductWithCategory(long id) throws Exception;



}
