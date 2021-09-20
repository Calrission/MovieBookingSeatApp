package com.example.ticketscinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInfoFilm()
    }

    private fun initInfoFilm(){
        title_film.text = Info.modelFilm.title
        contry_film.text = "${Info.modelFilm.country}, ${Info.modelFilm.version_D}D, ${Info.modelFilm.age}"
        category_film.text = "${Info.modelFilm.category}, ${Info.modelFilm.duration}"
        data_film.text = "${Info.modelFilm.data_film}"
        studio_film.text = Info.modelFilm.list_create_studio.joinToString(separator = ", ")
        rate_film.text = Info.modelFilm.rate_film.toString()

        Glide.with(this)
            .load(Info.modelFilm.src_cover)
            .into(cover_film)

        initRecGroup()
    }

    private fun initRecGroup(){
        rec_group_seats.apply {
            adapter = AdapterGroupSeat(Info.modelFilm.listGroupSeats)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        rec_group_seats.layoutManager!!.scrollToPosition(Info.modelFilm.listGroupSeats.lastIndex)
    }
}