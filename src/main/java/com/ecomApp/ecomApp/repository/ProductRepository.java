package com.ecomApp.ecomApp.repository;

import com.ecomApp.ecomApp.dto.ProductDto;
import com.ecomApp.ecomApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //HQL query(hibernate query)
    @Query("SELECT p from Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    //Raw SQl query

    @Query(value = "SELECT * FROM product WHERE MATCH(name,description) AGAINST (:keyword)", nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);

    @Query("SELECT p FROM Product p WHERE p.price > :minPrice AND p.brand = :brand")
    List<Product> findByBrandAndPrice(@Param("minPrice") int price,
                                      @Param("brand") String brand);


}
