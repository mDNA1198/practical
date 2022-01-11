package com.manish.practical.movie_details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manish.practical.models.MovieDetails
import com.manish.practical.models.MovieListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsViewModel constructor(private  val movieDetailsRepository: MovieDetailsRepository) : ViewModel(){

    private val TAG = MovieDetailsViewModel::class.java.name

    var movieDetailsModel = MutableLiveData<MovieDetails>()
    var isLoading = MutableLiveData<Boolean>()

    fun getMovieDetails(movieId: String){
        isLoading.postValue(true)
        movieDetailsRepository.getMovieDetails(movieId, "3e88ba33fd16654a358b713ae0c12219").enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                movieDetailsModel.postValue(response.body())
                isLoading.postValue(false)
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                Log.e(TAG, "${t.message} ${t.localizedMessage}")
                t.printStackTrace()
                isLoading.postValue(false)
            }
        })

    }


}