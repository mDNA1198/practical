package com.manish.practical.movie_details

class MovieDetailsRepository constructor(private val movieDetailsService: MovieDetailsService) {

    fun getMovieDetails(id: String, apiKey: String) = movieDetailsService.getMovieDetails(id, apiKey)

}