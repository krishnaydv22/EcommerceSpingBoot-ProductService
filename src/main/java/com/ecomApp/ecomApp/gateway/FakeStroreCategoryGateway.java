package com.ecomApp.ecomApp.gateway;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.FakeStoreCategoryResponseDto;
import com.ecomApp.ecomApp.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStroreCategoryGateway implements  ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStroreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDto response = fakeStoreCategoryApi.getAllFakeCategories().execute().body();
        if(response == null){
            throw new IOException("Failed to fetch category from fakeStore API");
        }

        return response.getCategories().stream().
                map( category -> CategoryDto.builder().name(category).build()).toList();


    }


}
