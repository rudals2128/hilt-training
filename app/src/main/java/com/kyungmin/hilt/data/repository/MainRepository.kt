package com.kyungmin.hilt.data.repository

import com.kyungmin.hilt.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getPhotos() = apiHelper.getPhotos()

}
