package com.kyungmin.hilt.data.api

import com.kyungmin.hilt.data.model.Photos
import retrofit2.Call

interface ApiHelper {

    suspend fun getPhotos(): Call<Photos>
}