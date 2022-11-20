package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.room.Room
import com.example.vrent.Model.Booking
import com.example.vrent.Model.ContactDatabase
import com.example.vrent.Model.Vehicle

class Booking_Complete : AppCompatActivity() {
    lateinit var cd : ContactDatabase
    var dd: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_complete)

        val bundle:Bundle? = intent.extras

        val vimg : Int? = bundle?.getInt("vehicleImg")
        val vehicleId:Int? = bundle?.getInt("vehicleId")
        val insurance:String? = bundle?.getString("insurance")
        val bookingid:Int? = bundle?.getInt("bookingId")
        val dayDiff:String? = bundle?.getString("daydiff")



        val vimage = findViewById<ImageView>(R.id.vehicleImage)
        val name = findViewById<TextView>(R.id.name)
        val email = findViewById<TextView>(R.id.email)
        val phone = findViewById<TextView>(R.id.phoneNumber)

        val vname = findViewById<TextView>(R.id.vehicleName)
        val vrate = findViewById<TextView>(R.id.rate)
        val days = findViewById<TextView>(R.id.totalDays)
        val pickup = findViewById<TextView>(R.id.pickup)
        val returndate = findViewById<TextView>(R.id.dropoff)
        val ins = findViewById<TextView>(R.id.insurance)
        val insrate = findViewById<TextView>(R.id.insuranceRate)
        val tcost = findViewById<TextView>(R.id.totalCost)
        val confirmBook = findViewById<Button>(R.id.book)
        val back = findViewById<Button>(R.id.back)

        back.setOnClickListener {
            if(bookingid!=null){
                cd.bookingDAO().deleteBooking(bookingid)}
            this.finish()
        }

        cd = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"mycontact4").allowMainThreadQueries().build()

        if(vimg!=null) vimage.setImageResource(vimg)
        if(vehicleId!=null){
            val vList:List<Vehicle>
            vList = cd.vehicleDAO().getVehicleInfo(vehicleId)
            vname.setText(""+vList[0].year+" "+vList[0].vname)
            vrate.setText("$"+vList[0].vprice+"/day")
        }
        if(insurance!=null){
            ins.setText(""+insurance)
            if(insurance=="None")  insrate.setText("$0")
            else if(insurance=="Basic") insrate.setText("$15")
            else insrate.setText("$25")
        }
        if(dayDiff!=null) {days.setText(""+(dayDiff.toInt()+1)+" days")}

        if(bookingid!=null){
            dd = bookingid
            val vList : List<Booking>
            vList = cd.bookingDAO().getBookingDetails(bookingid)
            name.setText(""+vList[0].DriverName)
            pickup.setText(""+vList[0].pickupDate)
            returndate.setText(""+vList[0].returnDate)
            email.setText(""+vList[0].Demail)
            phone.setText(""+vList[0].Dphone)
            tcost.setText("$"+vList[0].payAmount + " Cash")
        }

        confirmBook.setOnClickListener {
            val intent = Intent(this,Booking_Done::class.java)
            intent.putExtra("bookingId",bookingid)
            intent.putExtra("emailId",email.text.toString())
            startActivity(intent)
            this.finish()
        }
    }

    override fun onBackPressed() {
        if(dd!=null){
        cd.bookingDAO().deleteBooking(dd)}
        super.onBackPressed()
    }

}