package com.example.ticketscinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.ticketscinema.models.ModelLineSeats
import com.example.ticketscinema.models.ModelSeat
import kotlinx.android.synthetic.main.activity_main.*

object OnCLickSeat {
    lateinit var onClickSeat: OnClickSeatItem
}

class MainActivity : AppCompatActivity() {
    var messageIsShow = false
    var listSelectedSeats: MutableList<String> = arrayListOf()

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

        OnCLickSeat.onClickSeat = object: OnClickSeatItem{
            override fun onCLickSeat(
                modelSeat: ModelSeat,
                positionSeat: Int,
                positionLine: Int,
                positionGroup: Int
            ) {
               val nowStatus = modelSeat.status
               if (nowStatus != 1) {
                    if (nowStatus == 0) {
                        modelSeat.status = 2
                        listSelectedSeats.add(
                            "${Info.modelFilm.listGroupSeats[positionGroup].listLineSeats[positionLine].sim}${positionSeat + 1}")
                        updateMessageTexts()
                        if (!messageIsShow)
                            showMessage()
                    }else{
                        modelSeat.status = 0
                        listSelectedSeats.remove(
                            "${Info.modelFilm.listGroupSeats[positionGroup].listLineSeats[positionLine].sim}${positionSeat + 1}")
                        if (listSelectedSeats.isEmpty())
                            hideMessage()
                        updateMessageTexts()
                    }
                    rec_group_seats.adapter!!.notifyItemChanged(positionGroup)
                }else{
                    Toast.makeText(this@MainActivity, "Seat reserved !", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun updateMessageTexts(){
        text_message.text = "${listSelectedSeats.size} Sealt (${listSelectedSeats.joinToString(separator = ", ")})"
        cost.text = "Pay $${listSelectedSeats.size * 20}"
    }

    fun showMessage(){
        messageIsShow = true
        motion_message.transitionToEnd()
    }

    fun hideMessage(){
        messageIsShow = false
        motion_message.transitionToStart()
    }
}