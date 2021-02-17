package com.example.mykotlinapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView


@Suppress
class MainActivity : AppCompatActivity() {
    private val movieList = ArrayList<MovieModel>()
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var mDrawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolabr)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Home Screen"
            setHomeAsUpIndicator(android.R.drawable.ic_menu_manage)
        }

        mDrawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight

            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Handle navigation view item clicks here.
            when (menuItem.itemId) {

                R.id.home -> {

                    Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
                }
                R.id.profile -> {
                    startActivity(Intent(this, MapsActivity::class.java))

                }
                R.id.logout -> {
                    Toast.makeText(this, "Offer", Toast.LENGTH_LONG).show()
                }

            }

            true
        }


        val recyclerView: RecyclerView = findViewById(R.id.recy)
        moviesAdapter = MoviesAdapter(movieList, this)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        // recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = moviesAdapter
        prepareMovieData()

        findViewById<FloatingActionButton>(R.id.flotBtn).setOnClickListener {
            /*  val inten = Intent(this, AddDataRoom::class.java)
              startActivity(intent)*/
            startActivity(Intent(this, AddDataRoom::class.java))
        }
        val ss: String = intent.getStringExtra("key").toString()
        Log.e("TAG", "onCreate: " + ss)
        Toast.makeText(this, ss, Toast.LENGTH_LONG)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_share -> {
                Toast.makeText(applicationContext, "click on share", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_exit -> {
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    private fun prepareMovieData() {
        var movie = MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)
        movie = MovieModel("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)
        movie = MovieModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        movie = MovieModel("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)
        movie = MovieModel("The Martian", "Science Fiction & Fantasy", "2015")
        movieList.add(movie)
        movie = MovieModel("Mission: Impossible Rogue Nation", "Action", "2015")
        movieList.add(movie)
        movie = MovieModel("Up", "Animation", "2009")
        movieList.add(movie)
        movie = MovieModel("Star Trek", "Science Fiction", "2009")
        movieList.add(movie)
        movie = MovieModel("The LEGO MovieModel", "Animation", "2014")
        movieList.add(movie)
        movie = MovieModel("Iron Man", "Action & Adventure", "2008")
        movieList.add(movie)
        movie = MovieModel("Aliens", "Science Fiction", "1986")
        movieList.add(movie)
        movie = MovieModel("Chicken Run", "Animation", "2000")
        movieList.add(movie)
        movie = MovieModel("Back to the Future", "Science Fiction", "1985")
        movieList.add(movie)
        movie = MovieModel("Raiders of the Lost Ark", "Action & Adventure", "1981")
        movieList.add(movie)
        movie = MovieModel("Goldfinger", "Action & Adventure", "1965")
        movieList.add(movie)
        movie = MovieModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        movieList.add(movie)
        moviesAdapter.notifyDataSetChanged()
    }
}