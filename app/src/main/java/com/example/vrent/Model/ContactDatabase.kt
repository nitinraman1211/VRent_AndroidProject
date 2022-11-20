package com.example.vrent.Model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class,Vehicle::class,Booking::class], version = 2)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO
    abstract fun vehicleDAO(): VehicleDAO
    abstract fun bookingDAO(): BookingDAO
}