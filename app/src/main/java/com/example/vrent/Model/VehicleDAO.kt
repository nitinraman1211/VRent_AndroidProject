package com.example.vrent.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao

interface VehicleDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vehicle: Vehicle)

    @Update
    suspend fun update(vehicle: Vehicle)

    @Delete
    suspend fun delete(vehicle: Vehicle)

    @Query("SELECT * FROM vehicle")
    fun getVehicle(): LiveData<List<Vehicle>>

    @Query("Select * From vehicle where vehicleid =:value1")
    fun getVehicleInfo(value1:Int): MutableList<Vehicle>

    @Query("Select vprice From vehicle where vehicleid =:value1")
    fun getVehiclePrice(value1: Int):Int

    @Query("Select vname from vehicle where vehicleid =:value1")
    fun getVname(value1: Int):String

}