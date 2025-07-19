package com.ecomApp.ecomApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product extends BaseEntity{

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
//    private int id;
    private String title;
//    private String category;
    private String brand;
    private boolean popular;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;


}
