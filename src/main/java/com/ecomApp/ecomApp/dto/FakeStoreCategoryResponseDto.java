package com.ecomApp.ecomApp.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreCategoryResponseDto {

    private String status;
    private String message;
    private List<String> categories;

}
