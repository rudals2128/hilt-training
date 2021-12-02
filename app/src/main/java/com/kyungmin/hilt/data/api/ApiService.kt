package com.kyungmin.hilt.data.api

import com.kyungmin.hilt.data.model.Photos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    fun getPhotos(
        @Query("query") title: String,
        @Query("per_page") page: Int,
        @Query("client_id") key: String
    ): Call<Photos>

}