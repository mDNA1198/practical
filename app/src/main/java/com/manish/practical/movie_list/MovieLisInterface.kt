package com.manish.practical.movie_list

import com.manish.practical.models.MovieItem

interface MovieLisInterface {

    interface MovieListView{
        fun onAMovieClicked(movie: MovieItem)
        fun loadMovieList()
    }

}