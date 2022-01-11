package com.manish.practical.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class MovieListModel(
    @SerializedName("page") var page: Int,
    @SerializedName("results") var results: ArrayList<MovieItem> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("total_results") var totalResults : Int
)
