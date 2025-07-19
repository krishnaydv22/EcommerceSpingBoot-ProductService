package com.ecomApp.ecomApp.gateway;

import com.ecomApp.ecomApp.dto.CategoryDto;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDto> getAllCategories() throws IOException;


}
