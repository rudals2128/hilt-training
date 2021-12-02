package com.kyungmin.hilt.data.api

import com.kyungmin.hilt.BuildConfig
import com.kyungmin.hilt.data.model.Photos
import retrofit2.Call
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getPhotos(): Call<Photos> =
        apiService.getPhotos("android",30, BuildConfig.BASE_KEY)

}