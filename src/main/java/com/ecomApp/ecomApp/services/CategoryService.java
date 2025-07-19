package com.ecomApp.ecomApp.services;

import com.ecomApp.ecomApp.dto.CategoryDto;
import com.ecomApp.ecomApp.dto.CategoryWithProductDto;
import com.ecomApp.ecomApp.entity.Category;
import com.ecomApp.ecomApp.exception.CategoryNotFoundException;
import com.ecomApp.ecomApp.mappers.CategoryMapper;
import com.ecomApp.ecomApp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("categoryService")
public class CategoryService implements ICategoryService{

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CategoryDto> getAllCategories(){
        return this.repo.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        Category response =  this.repo.save(CategoryMapper.toEntity(dto));
        return CategoryMapper.toDto(response);
    }

    @Override
    public CategoryDto getByName(String name) throws Exception{

        Category category =  this.repo.findByName(name)
                 .orElseThrow(() -> new CategoryNotFoundException("Category not found "));
        return CategoryMapper.toDto(category);
    }

    @Override
    public CategoryWithProductDto getAllProductsOfCategory(long id) throws Exception {
        Category category = repo.findById(id)
                .orElseThrow(() -> new Exception("Category not found with id" + id));

        return CategoryMapper.categoryWithProductDto(category);
    }


}
