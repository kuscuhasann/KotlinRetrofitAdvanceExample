package com.pakt_games.kotlinretrofitadvanceexample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pakt_games.kotlinretrofitadvanceexample.R
import com.pakt_games.kotlinretrofitadvanceexample.data.model.Movie
import kotlinx.android.synthetic.main.retrofit_calisma_recycler_row.view.*

class RetrofitCalismaRecyclerAdapter(private val movies: ArrayList<Movie>) : RecyclerView.Adapter<RetrofitCalismaRecyclerAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: Movie) {
            itemView.apply {
                textViewUserName.text = user.title
                textViewUserEmail.text = user.release_date
                Glide.with(imageViewAvatar.context)
                    .load("https://image.tmdb.org/t/p/w500/"+user.backdrop_path)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.retrofit_calisma_recycler_row, parent, false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun addMovies(movies: List<Movie>) {
        this.movies.apply {
            clear()
            addAll(movies)
        }

    }
}