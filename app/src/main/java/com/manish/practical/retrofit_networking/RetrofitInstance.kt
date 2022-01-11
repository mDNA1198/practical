package com.manish.practical.retrofit_networking

import com.manish.practical.movie_details.MovieDetailsService
import com.manish.practical.movie_list.MovieListService
import com.manish.practical.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofitClient: Retrofit.Builder by lazy {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())

    }

    val movieListService: MovieListService by lazy {
        retrofitClient.build().create(MovieListService::class.java)
    }

    val movieDetailsService: MovieDetailsService by lazy {
        retrofitClient.build().create(MovieDetailsService::class.java)
    }

}