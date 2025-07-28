package com.ecomApp.ecomApp.service;
import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.CategoryWithProductDto;
import com.ecomApp.ecomApp.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryServices implements ICategoryService {

    private final ICategoryGateway iCategoryGateway;

    public FakeStoreCategoryServices(@Qualifier("fakeStoreRestTeamplateGateway")
            ICategoryGateway iCategoryGateway){
        this.iCategoryGateway = iCategoryGateway;
    }
    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        return iCategoryGateway.getAllCategories();
    }

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        return null;
    }

    @Override
    public CategoryDto getByName(String name) {
        return null;
    }

    @Override
    public CategoryWithProductDto getAllProductsOfCategory(long id) throws Exception {
        return null;
    }
}
