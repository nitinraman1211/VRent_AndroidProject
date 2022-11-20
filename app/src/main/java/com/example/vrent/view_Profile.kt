package com.example.vrent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.vrent.Model.Contact
import com.example.vrent.Model.ContactDatabase

class view_Profile : AppCompatActivity() {
    lateinit var cdbase : ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)

        val name = findViewById<TextView>(R.id.name1)
        val email = findViewById<TextView>(R.id.email1)
        val phone = findViewById<TextView>(R.id.phoneNumber1)
        val dl = findViewById<TextView>(R.id.drivingLicense1)
        val ed = findViewById<TextView>(R.id.expiryDate1)
        val dob = findViewById<TextView>(R.id.dateOfBirth1)
        val street = findViewById<TextView>(R.id.street1)
        val city = findViewById<TextView>(R.id.city1)
        val postal = findViewById<TextView>(R.id.postalCode1)

        cdbase = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"mycontact4").allowMainThreadQueries().build()

        val bundle:Bundle? = intent.extras
        val resid:String? = bundle?.getString("emailId")

        if(resid!=null){
         val cList:List<Contact> = cdbase.contactDAO().getContactDetails(resid)
            name.setText(""+cList[0].name)
            email.setText(""+cList[0].email)
            phone.setText(""+cList[0].phone)
            dl.setText(""+cList[0].driving_license)
            ed.setText(""+cList[0].expiry_date)
            dob.setText(""+cList[0].dob)
            street.setText(""+cList[0].street)
            city.setText(""+cList[0].city)
            postal.setText(""+cList[0].postal_code)
        }
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            this.finish()
        }

    }
}