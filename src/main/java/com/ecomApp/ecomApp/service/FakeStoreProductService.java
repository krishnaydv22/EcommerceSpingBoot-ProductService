package com.ecomApp.ecomApp.service;

import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.dto.ProductWihCategoryDto;
import com.ecomApp.ecomApp.gateway.IProductGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService{

    private final IProductGateway iProductGateway;

    public FakeStoreProductService(IProductGateway iProductGateway) {
        this.iProductGateway = iProductGateway;
    }

    @Override
    public ProductDto getProductById(Long id) {
        try {
            return this.iProductGateway.getProductById(id);

        } catch (Exception e) {

        }

        return null;
    }



    @Override
    public ProductDto createProduct(ProductDto dto) {
        return null;
    }

    @Override
    public ProductWihCategoryDto getProductWithCategory(long id) throws Exception {
        return null;
    }
}
