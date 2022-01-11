package com.manish.practical.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manish.practical.databinding.SingleRowForMovieListBinding
import com.manish.practical.models.MovieItem
import com.manish.practical.movie_list.MovieLisInterface
import com.manish.practical.utils.AppConstants

class MovieListRecyclerView(private val context: Context, val view: MovieLisInterface.MovieListView) : RecyclerView.Adapter<MovieListRecyclerView.MovieListViewHolder>(){

    private var movieList: ArrayList<MovieItem> = arrayListOf()

    fun setMovieList(list: ArrayList<MovieItem>){
        movieList.addAll(list)
        notifyItemRangeInserted((movieList.size + 1), list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListRecyclerView.MovieListViewHolder {
        val binding: SingleRowForMovieListBinding = SingleRowForMovieListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListRecyclerView.MovieListViewHolder, position: Int) {
        holder.bindData(position)
        if (position == movieList.size - 1 && position <= movieList.size) {
            view.loadMovieList()
        }
    }

    override fun getItemCount(): Int = movieList.size

    inner class MovieListViewHolder(val binding: SingleRowForMovieListBinding): RecyclerView.ViewHolder(binding.root){

        fun bindData(position: Int){
            binding.data = movieList[position]

            Glide.with(context).load("${AppConstants.GET_FRONT_IMAGE}${movieList[position].posterPath}").into(binding.moviePosterIV)

            binding.root.setOnClickListener{
                view.onAMovieClicked(movieList[position])
            }
        }

    }

}
