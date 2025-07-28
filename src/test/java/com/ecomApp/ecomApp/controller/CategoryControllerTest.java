package com.ecomApp.ecomApp.controller;

import com.ecomApp.ecomApp.controllers.CategoryController;
import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.exception.GlobalExceptionHandler;
import com.ecomApp.ecomApp.service.ICategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private ICategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

   private  List<CategoryDto> categories;

   private MockMvc mockMvc;



    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        categories = new ArrayList<>();
        categories.add(CategoryDto.builder().name("electronics").id(1).build());
        categories.add(CategoryDto.builder().name("books").id(2).build());
        categories.add(CategoryDto.builder().name("footwear").id(3).build());


    }


    @Test
    @DisplayName("GET api/categories should return all categories")
    void getAllCategories_shouldGetAllCategories() throws Exception {

        //Arrange
        when(categoryService.getAllCategories()).thenReturn(categories);

        //Act & assert
        mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("electronics"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("books"));
        //assert
        verify(categoryService,times(1)).getAllCategories();






    }


}
