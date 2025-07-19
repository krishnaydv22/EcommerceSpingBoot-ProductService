package com.ecomApp.ecomApp.controllers;

import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.dto.ProductWihCategoryDto;
import com.ecomApp.ecomApp.exception.ProductNotFoundException;
import com.ecomApp.ecomApp.services.IProductService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(@Qualifier("productService") IProductService iProductService) {

        this.productService = iProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductsById(@PathVariable Long id)  {
        ProductDto response =  this.productService.getProductById(id);
     return ResponseEntity.ok(response);

    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) throws Exception {
        return  ResponseEntity.ok(productService.createProduct(dto));

    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWihCategoryDto> getProductWithCategory(@PathVariable long id) throws Exception{
        ProductWihCategoryDto dto =   productService.getProductWithCategory(id);
        return  ResponseEntity.ok(dto);


    }


}
