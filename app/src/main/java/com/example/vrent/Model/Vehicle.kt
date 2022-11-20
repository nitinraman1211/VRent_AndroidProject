package com.example.vrent.Model

import androidx.room.Entity

@Entity(primaryKeys = ["vehicleid"])
data class Vehicle(
    val vehicleid:Int,
    val vname:String,
    val vprice: Int,
    val vengine:String,
    val vseat:Int,
    val milege:String,
    val manufacturer:String,
    val year:Int,
    val type:String
)