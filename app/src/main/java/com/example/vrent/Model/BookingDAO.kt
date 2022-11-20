package com.example.vrent.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BookingDAO {
   @Insert
    suspend fun insert(booking: Booking)

    @Update
    suspend fun update(booking: Booking)

    @Delete
    suspend fun delete(booking: Booking)

    @Query("SELECT * FROM booking")
    fun getBooking(): LiveData<List<Booking>>

    @Query("Select * From booking where bookingId=:value1")
    fun getBookingDetails(value1:Int):List<Booking>

    @Query("Delete from booking where bookingId=:value1")
    fun deleteBooking(value1: Int)

    @Query("Select * from booking where Demail=:value1")
    fun getBook(value1: String):List<Booking>
}