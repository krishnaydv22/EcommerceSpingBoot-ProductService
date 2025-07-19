package com.ecomApp.ecomApp.gateway;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.FakeStoreCategoryResponseDto;
import com.ecomApp.ecomApp.exception.CategoryNotFoundException;
import com.ecomApp.ecomApp.mappers.GetAllCategoryMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTeamplateGateway")
public class FakeStoreRestTeamplateGateway implements ICategoryGateway {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTeamplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<CategoryDto> getAllCategories(){
        RestTemplate restTemplate =  this.restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category";
        ResponseEntity<FakeStoreCategoryResponseDto> response =   restTemplate.getForEntity(url, FakeStoreCategoryResponseDto.class);
        if(response.getBody() == null){
            throw new CategoryNotFoundException("no response");
        }

        return GetAllCategoryMapper.toCategoryDto(response.getBody());
    }
}
