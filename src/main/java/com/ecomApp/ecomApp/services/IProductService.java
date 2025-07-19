package com.ecomApp.ecomApp.services;

import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.dto.ProductWihCategoryDto;
import com.ecomApp.ecomApp.entity.Product;

public interface IProductService {
    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto dto) throws Exception;

   ProductWihCategoryDto getProductWithCategory(long id) throws Exception;



}
