package com.ecomApp.ecomApp.services;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.entity.Category;
import com.ecomApp.ecomApp.repository.CategoryRepository;
import com.ecomApp.ecomApp.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private CategoryDto categoryDto;
    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    void setUp(){

        categoryDto = CategoryDto.builder().name("Electronics").build();

        category1 = Category.builder().name("Electronics").build();
        category1.setId(1);

        category2 = Category.builder().name("Books").build();
        category2.setId(2);

        category3 = Category.builder().name("Footwear").build();
        category3.setId(3);




    }


    @Test
    @DisplayName("Should return all categories")
    void getAllCategories_ShouldReturnAllCategories(){

        //Arrange
        List<Category> categories = new ArrayList<>();

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);



        when(categoryRepository.findAll()).thenReturn(categories); // mocked the repo to return categories

        //Act

        List<CategoryDto> result = categoryService.getAllCategories(); // this is actually get called

        //Assert
        assertEquals(result.size(),3);
        assertEquals(result.get(0).getName(),"Electronics");
        verify(categoryRepository,times(1)).findAll(); //verifies that it is coming from mocked object

    }

    @Test
    @DisplayName("this should create category")
    void createCategory_shouldCreateCategory(){

        //Arrange
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);

        //Act
        CategoryDto result = categoryService.createCategory(categoryDto);

        //assert
        assertEquals(result.getName(),"Electronics");
        verify(categoryRepository,times(1)).save(any(Category.class)); //verifies that it is coming from mocked object







    }
}
