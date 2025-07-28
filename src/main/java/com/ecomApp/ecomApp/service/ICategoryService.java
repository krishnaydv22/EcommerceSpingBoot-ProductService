package com.ecomApp.ecomApp.service;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.CategoryWithProductDto;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
List<CategoryDto>  getAllCategories() throws IOException;

CategoryDto createCategory(CategoryDto dto);

CategoryDto getByName(String name) throws Exception;;

CategoryWithProductDto getAllProductsOfCategory(long id) throws Exception;
}
