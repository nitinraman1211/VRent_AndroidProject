package com.example.vrent.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface ContactDAO {
    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<Contact>>

    @Query("select count(*) from contact where email =:value")
    fun findcontact(value:String):Int

    @Query("select name from contact where email =:value1 and password=:value2")
    fun checkcontact(value1:String,value2:String):String

    @Query("select password from contact where email=:value1")
    fun checkpass(value1: String):String

    @Query("select * from contact where email=:value1")
    fun getContactDetails(value1: String):List<Contact>

}