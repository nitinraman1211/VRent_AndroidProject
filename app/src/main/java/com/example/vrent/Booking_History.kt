package com.example.vrent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.vrent.Model.Booking
import com.example.vrent.Model.BookingHistory
import com.example.vrent.Model.ContactDatabase

class Booking_History : AppCompatActivity() {
    lateinit var cdata : ContactDatabase
    lateinit var bhlist:MutableList<BookingHistory>
    lateinit var recyclerView : RecyclerView
    var myRecyclerAdapter:MyRecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_history)

        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener { finish() }

        cdata = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"mycontact4").allowMainThreadQueries().build()
        val bundle:Bundle? = intent.extras
        val reid:String? = bundle?.getString("emailId")
        if(reid!=null){
          val blist:List<Booking>
          blist = cdata.bookingDAO().getBook(reid)
          bhlist = mutableListOf<BookingHistory>()
            var vehname:String
         for(i in 0..blist.size-1){
             vehname = cdata.vehicleDAO().getVname(blist[i].vehicleId)
             bhlist.add(BookingHistory(blist[i].bookingId.toString(),vehname,blist[i].pickupDate,blist[i].returnDate,blist[i].DriverName,blist[i].Demail,
             blist[i].Dphone.toString(),blist[i].payAmount.toInt()))
         }
        }

        recyclerView = findViewById(R.id.recV1)
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.setLayoutManager(linearLayoutManager)
        myRecyclerAdapter = MyRecyclerAdapter(this,bhlist)
        recyclerView.adapter = myRecyclerAdapter

    }
}