package com.example.ticketscinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketscinema.models.ModelGroupSeats
import com.example.ticketscinema.models.ModelLineSeats
import com.example.ticketscinema.models.ModelSeat

class AdapterGroupSeat(var listGroup: List<ModelGroupSeats>): RecyclerView.Adapter<AdapterGroupSeat.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rec_lines = itemView.findViewById<RecyclerView>(R.id.rec_lines)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rec_lines.apply {
            adapter = AdapterLineSeat(listGroup[position].listLineSeats, position)
            layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun getItemCount(): Int = listGroup.size
}