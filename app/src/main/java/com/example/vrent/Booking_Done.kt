package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Booking_Done : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_done2)

        val bundle:Bundle? = intent.extras
        val bookingid:Int? = bundle?.getInt("bookingId")
        val emid:String? = bundle?.getString("emailId")
        val bid = findViewById<TextView>(R.id.bookingID)
        val returnBtn = findViewById<Button>(R.id.rth)
        val back = findViewById<Button>(R.id.back)
        if(bookingid!=null) bid.setText("BookingID: "+bookingid.toString())


        back.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        returnBtn.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("emailId",emid)
            startActivity(intent)
            this.finish()
        }
    }
}