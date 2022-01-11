package com.manish.practical.movie_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manish.practical.models.MovieListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel constructor(private  val movieListRepository: MovieListRepository) : ViewModel(){

    private val TAG = MovieListViewModel::class.java.name

    var movieListModel = MutableLiveData<MovieListModel>()

    private var page = 1
    var isLoading = MutableLiveData<Boolean>()

    fun getMovieList(){
        isLoading.postValue(true)
        movieListRepository.getMovieList("3e88ba33fd16654a358b713ae0c12219", page).enqueue(object : Callback<MovieListModel> {
            override fun onResponse(call: Call<MovieListModel>, response: Response<MovieListModel>) {
                movieListModel.postValue(response.body())
                page += 1
                isLoading.postValue(false)
            }

            override fun onFailure(call: Call<MovieListModel>, t: Throwable) {
                Log.e(TAG, "${t.message} ${t.localizedMessage}")
                t.printStackTrace()
                isLoading.postValue(false)
            }
        })

    }


}