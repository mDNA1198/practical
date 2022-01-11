package com.manish.practical.movie_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MovieDetailsViewModelFactory(private val movieDetailsRepository: MovieDetailsRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)){
            return MovieDetailsViewModel(this.movieDetailsRepository) as T
        }else {
            throw IllegalArgumentException("View model not found")
        }
    }

}