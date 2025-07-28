package com.ecomApp.ecomApp.service;

import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.dto.ProductWihCategoryDto;
import com.ecomApp.ecomApp.entity.Category;
import com.ecomApp.ecomApp.entity.Product;
import com.ecomApp.ecomApp.exception.ProductNotFoundException;
import com.ecomApp.ecomApp.mappers.ProductMapper;
import com.ecomApp.ecomApp.repository.CategoryRepository;
import com.ecomApp.ecomApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService implements IProductService{

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository) {
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto getProductById(Long id){
        Product product = repo.findById(id).orElseThrow( () -> new ProductNotFoundException("Product not found with id " + id));

        return ProductMapper.toDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto dto) throws Exception {
       Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("category not found with id " + dto.getCategoryId()));
       Product saved =  repo.save(ProductMapper.toEntity(dto,category));

        return ProductMapper.toDto(saved);
    }

    @Override
    public ProductWihCategoryDto getProductWithCategory(long id) throws Exception {
        Product product= repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
        return ProductMapper.toProductWihCategoryDto(product);
    }
}
