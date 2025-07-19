package com.ecomApp.ecomApp.gateway.api;

import com.ecomApp.ecomApp.dto.FakeStoreCategoryResponseDto;
import com.ecomApp.ecomApp.dto.FakeStoreProductResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<FakeStoreProductResponseDto> getProductById(@Path("id") Long id) throws IOException;



}
