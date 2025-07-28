package com.ecomApp.ecomApp.controllers;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.CategoryWithProductDto;
import com.ecomApp.ecomApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(@Qualifier("categoryService") ICategoryService iCategoryService)
    {
        this.categoryService = iCategoryService;
    }

    @GetMapping
    public ResponseEntity<?> getCategory(@RequestParam(required = false) String name) throws Exception {
             if(name != null && !name.isBlank()){
                CategoryDto categoryDto =  categoryService.getByName(name);
                 return ResponseEntity.ok(categoryDto);
             }


                List<CategoryDto> response = categoryService.getAllCategories();

                return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto) throws IOException {
        return ResponseEntity.ok(categoryService.createCategory(dto));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<CategoryWithProductDto> getAllProductsOfCategory(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(categoryService.getAllProductsOfCategory(id));


    }







}
