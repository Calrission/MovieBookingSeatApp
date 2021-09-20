package com.example.ticketscinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketscinema.models.ModelSeat

class AdapterSeat(var listSeat: List<ModelSeat>, val positionLine: Int, val positionGroup: Int): RecyclerView.Adapter<AdapterSeat.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val seat = itemView.findViewById<CardView>(R.id.card_seat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_seat, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.seat.setCardBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, when(listSeat[position].status){
                0 -> R.color.available
                1 -> R.color.reserved
                else -> R.color.selected
        }))

        holder.seat.setOnClickListener {
            OnCLickSeat.onClickSeat.onCLickSeat(listSeat[position], position, positionLine, positionGroup)
        }
    }

    override fun getItemCount(): Int = listSeat.size
}