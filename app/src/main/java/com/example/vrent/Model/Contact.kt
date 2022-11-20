package com.example.vrent.Model

import androidx.room.Entity
import java.util.Date

@Entity(primaryKeys = ["email"])
data class Contact(
    val name: String,
    val email: String,
    val driving_license : String,
    val expiry_date : String,
    val dob:String,
    val phone:Long,
    val street:String,
    val city:String,
    val postal_code:Int,
    val password:String
)