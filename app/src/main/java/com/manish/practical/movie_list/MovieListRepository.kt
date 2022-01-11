package com.manish.practical.movie_list

class MovieListRepository constructor(private val movieListService: MovieListService) {

    fun getMovieList(apiKey: String, page: Int) = movieListService.getMovieList(apiKey, page)

}