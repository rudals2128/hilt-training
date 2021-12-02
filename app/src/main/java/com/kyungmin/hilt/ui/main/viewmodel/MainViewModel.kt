package com.kyungmin.hilt.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyungmin.hilt.data.model.Items
import com.kyungmin.hilt.data.model.Photos
import com.kyungmin.hilt.data.repository.MainRepository
import com.kyungmin.hilt.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _photos: MutableLiveData<ArrayList<Items>> = MutableLiveData()
    val photos: LiveData<ArrayList<Items>>
        get() = _photos

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPhotos().enqueue(object : Callback<Photos> {
                    override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                        if (response.isSuccessful) {
                            _photos.value = response.body()?.results
                        }
                    }

                    override fun onFailure(call: Call<Photos>, t: Throwable) {
                    }
                })
            }
        }
    }
}


