package com.manish.practical.movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MovieListViewModelFactory(private val movieListRepository: MovieListRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MovieListViewModel::class.java)){
            return MovieListViewModel(this.movieListRepository) as T
        }else {
            throw IllegalArgumentException("View model not found")
        }
    }

}