package com.example.mykotlinapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class MoviesAdapter(
    private var moviesList: List<MovieModel>,
    private var mainActivity: MainActivity
) :
    RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {
// this is osnge line commet
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var year: TextView = view.findViewById(R.id.year)
        var genre: TextView = view.findViewById(R.id.genre)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.getTitle()
        holder.genre.text = movie.getGenre()
        holder.year.text = movie.getYear()

        holder.itemView.setOnClickListener {
            Log.e("TAG", "onBindViewHolder: " + movie.getTitle())
            Toast.makeText(mainActivity, "name", Toast.LENGTH_LONG).show()
        }
    }
    override fun getItemCount(): Int {
        return moviesList.size
    }
}