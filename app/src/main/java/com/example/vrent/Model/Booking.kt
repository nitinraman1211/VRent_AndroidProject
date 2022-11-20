package com.example.vrent.Model

import androidx.room.Entity

@Entity(primaryKeys = ["bookingId"])
data class Booking(
    val bookingId:Int,
    val bookingDate: String,
    val pickupDate:String,
    val returnDate:String,
    val DriverName:String,
    val Demail:String,
    val Dphone:Int,
    val Insurance:String,
    val payAmount:Long,
    val vehicleId:Int
    )