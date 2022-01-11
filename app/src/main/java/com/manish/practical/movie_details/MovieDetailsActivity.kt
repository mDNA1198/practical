package com.manish.practical.movie_details

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.manish.practical.databinding.ActivityMovieDetailsBinding
import com.manish.practical.retrofit_networking.RetrofitInstance
import com.manish.practical.utils.AppConstants

class MovieDetailsActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMovieDetailsBinding

    private val movieDetailsService = RetrofitInstance.movieDetailsService
    private lateinit var movieViewModel: MovieDetailsViewModel

    private var movieId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFromIntent()
        initUI()
        initObservers()
        loadMovieList()
    }

    private fun getDataFromIntent(){
        movieId = intent.getIntExtra("movieId", 0)
    }

    private fun initUI(){
        movieViewModel = ViewModelProvider(this, MovieDetailsViewModelFactory(MovieDetailsRepository(movieDetailsService)))[MovieDetailsViewModel::class.java]
    }

    private fun initObservers(){
        movieViewModel.movieDetailsModel.observe(this, {
            binding.data = it
            Glide.with(this).load("${AppConstants.GET_BACK_IMAGE}${it.backdropPath}").into(binding.backIV)
            Glide.with(this).load("${AppConstants.GET_FRONT_IMAGE}${it.posterPath}").into(binding.frontIV)
        })

        movieViewModel.isLoading.observe(this, {
            if(it){
                binding.progressIndicator.visibility = View.VISIBLE
            }else{
                binding.progressIndicator.visibility = View.GONE
            }
        })
    }

    private fun loadMovieList(){
        if(movieId != 0){
            movieViewModel.getMovieDetails(movieId.toString())
        }else{
            Toast.makeText(this, "Unable to get movie details", Toast.LENGTH_SHORT).show()
        }
    }

}