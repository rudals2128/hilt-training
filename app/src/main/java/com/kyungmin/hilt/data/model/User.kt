package com.kyungmin.hilt.data.model


data class Photos(
    var results: ArrayList<Items>
)

data class Items(
    var urls: Urls
)

data class Urls(
    var small: String
)