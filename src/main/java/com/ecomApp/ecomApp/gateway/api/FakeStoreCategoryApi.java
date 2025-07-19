package com.ecomApp.ecomApp.gateway.api;

import com.ecomApp.ecomApp.dto.FakeStoreCategoryResponseDto;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

@Component
public interface FakeStoreCategoryApi {

    @GET("products/category")
    Call<FakeStoreCategoryResponseDto> getAllFakeCategories() throws IOException;

}
