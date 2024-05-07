package com.mx.liverpool.demoitems.data.remote

import com.mx.liverpool.demoitems.data.network.models.ApiResponse
import retrofit2.Response


import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("services/v3/plp")
    suspend fun searchItems(
        @Query("search-string") searchString: String,
        @Query("page-number") pageNumber: Int,
        @Query("sortPrice") sortPrice: Int? = null
    ): Response<ApiResponse>
}