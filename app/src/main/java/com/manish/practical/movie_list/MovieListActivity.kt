package com.manish.practical.movie_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.manish.practical.adapters.MovieListRecyclerView
import com.manish.practical.databinding.ActivityMovieListBinding
import com.manish.practical.models.MovieItem
import com.manish.practical.movie_details.MovieDetailsActivity
import com.manish.practical.retrofit_networking.RetrofitInstance

class MovieListActivity: AppCompatActivity(), MovieLisInterface.MovieListView {

    private lateinit var binding: ActivityMovieListBinding
    private lateinit var adapter: MovieListRecyclerView

    private val movieListService = RetrofitInstance.movieListService
    private lateinit var movieViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initObservers()
        loadMovieList()
    }

    private fun initUI(){

        movieViewModel = ViewModelProvider(this, MovieListViewModelFactory(MovieListRepository(movieListService)))[MovieListViewModel::class.java]

        binding.movieListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = MovieListRecyclerView(this, this)
        binding.movieListRV.adapter = adapter
    }

    private fun initObservers(){
        movieViewModel.movieListModel.observe(this, {
            adapter.setMovieList(it.results)
        })

        movieViewModel.isLoading.observe(this, {
            if(it){
                binding.progressIndicator.visibility = View.VISIBLE
            }else{
                binding.progressIndicator.visibility = View.GONE
            }
        })
    }

    override fun loadMovieList(){
        movieViewModel.getMovieList()
    }

    override fun onAMovieClicked(movie: MovieItem) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movieId", movie.id)
        startActivity(intent)
    }
}