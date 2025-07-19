package com.ecomApp.ecomApp.gateway;

import com.ecomApp.ecomApp.dto.FakeStoreProductResponseDto;
import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service

public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception {
        FakeStoreProductResponseDto response =  this.fakeStoreProductApi.getProductById(id).execute().body();
        if(response == null){
            throw new Exception("Product not found with given id");
        }
        return response.getProduct();

    }
}
