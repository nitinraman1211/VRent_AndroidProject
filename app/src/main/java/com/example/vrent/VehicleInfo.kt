package com.example.vrent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.vrent.Model.ContactDatabase
import com.example.vrent.Model.Vehicle

class VehicleInfo : AppCompatActivity() {

    lateinit var datab : ContactDatabase
    lateinit var list : MutableList<Vehicle>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_info)

        var vImg = findViewById<ImageView>(R.id.vehicleImage)
        var vname = findViewById<TextView>(R.id.vehicleTitle)
        var vprice = findViewById<TextView>(R.id.vehiclePrice)
        var vmanufacturer = findViewById<TextView>(R.id.manufacturer)
        var vyear = findViewById<TextView>(R.id.year)
        var vengine = findViewById<TextView>(R.id.engine)
        var vfuelType = findViewById<TextView>(R.id.type)
        var vmilege = findViewById<TextView>(R.id.mileage)
        var vseats = findViewById<TextView>(R.id.seats)

        var back = findViewById<Button>(R.id.back)

        var bookBtn = findViewById<Button>(R.id.book_this_car)

        val insuranceOp = findViewById<RadioGroup>(R.id.insuranceOption)


        //BACK ARROW BUTTON LISTENER
        back.setOnClickListener { finish() }

        datab = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "mycontact4")
            .allowMainThreadQueries().build()
        val bundle: Bundle? = intent.extras
        val resId: Int? = bundle?.getInt("vehicleId")
        val imgId:Int? = bundle?.getInt("vehicleImg")
        if (resId != null) {
          list =   datab.vehicleDAO().getVehicleInfo(resId)
            vname.setText(""+list[0].vname)
            vprice.setText("$"+list[0].vprice+"/day")
            vmanufacturer.setText(""+list[0].manufacturer)
            vyear.setText(""+list[0].year)
            vengine.setText(""+list[0].vengine)
            vfuelType.setText(""+list[0].type)
            vmilege.setText(""+list[0].milege)
            vseats.setText(""+list[0].vseat)
        }
        if(imgId!=null) vImg.setImageResource(imgId)


        bookBtn.setOnClickListener {
            val insuranceId = insuranceOp.checkedRadioButtonId
            val radio:RadioButton = findViewById(insuranceId)
            val intent = Intent(this,Booking_Vehicle::class.java)
            intent.putExtra("vehicleId",resId)
            intent.putExtra("vehicleImg",imgId)
            intent.putExtra("insurance",radio.text)
            startActivity(intent)

        }



    }

}