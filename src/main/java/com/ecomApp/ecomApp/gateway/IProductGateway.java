package com.ecomApp.ecomApp.gateway;

import com.ecomApp.ecomApp.dto.ProductDto;

import java.io.IOException;

public interface IProductGateway {
    ProductDto getProductById(Long id) throws Exception;

}
