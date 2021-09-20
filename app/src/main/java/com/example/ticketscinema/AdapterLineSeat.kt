package com.example.ticketscinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketscinema.models.ModelLineSeats
import com.example.ticketscinema.models.ModelSeat

class AdapterLineSeat(var listLine: List<ModelLineSeats>, val positionGroup: Int): RecyclerView.Adapter<AdapterLineSeat.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rec_seat = itemView.findViewById<RecyclerView>(R.id.rec_seats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_line_seat, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val linearLayout = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.rec_seat.apply {
            adapter = AdapterSeat(listLine[position].listSeats, position, positionGroup)
            layoutManager = linearLayout
        }
    }

    override fun getItemCount(): Int = listLine.size
}