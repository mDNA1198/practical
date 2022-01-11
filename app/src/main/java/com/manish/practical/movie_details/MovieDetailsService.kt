package com.manish.practical.movie_details

import com.manish.practical.models.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsService {

    @GET("movie/{id}")
    fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") api_key: String
    ): Call<MovieDetails>

}