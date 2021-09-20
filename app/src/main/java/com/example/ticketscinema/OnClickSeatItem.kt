package com.example.ticketscinema

import com.example.ticketscinema.models.ModelSeat

interface OnClickSeatItem {
    fun onCLickSeat(modelSeat: ModelSeat, positionSeat: Int, positionLine: Int, positionGroup: Int)
}