package com.manish.practical.movie_list

import com.manish.practical.models.MovieListModel
import com.manish.practical.utils.AppConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListService {

    @GET(AppConstants.GET_MOVIES)
    fun getMovieList(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ) : Call<MovieListModel>

}