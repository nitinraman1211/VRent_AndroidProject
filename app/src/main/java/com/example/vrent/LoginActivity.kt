package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.vrent.Model.ContactDatabase
import com.example.vrent.Model.Vehicle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    lateinit var db:ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login)

        db = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "mycontact4")
            .allowMainThreadQueries().build()

        val edtemail = findViewById<EditText>(R.id.email)
        val edtpass = findViewById<EditText>(R.id.password)
        val btn = findViewById<Button>(R.id.login)
        val register = findViewById<TextView>(R.id.registertxt)

        register.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

        GlobalScope.launch(Dispatchers.IO) {
            try {

                db.vehicleDAO().insert(
                    Vehicle(
                        101,
                        "BMW X4 Sports",
                        210,
                        "2993 cc",
                        5,
                        "14.23 kmpl",
                        "BMW",
                        2019,
                        "Diesel"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        102,
                        "Audi A7 2018",
                        190,
                        "2967 cc",
                        5,
                        "13.88 kmpl",
                        "Audi",
                        2018,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        103,
                        "Ford Mustang GT",
                        220,
                        "4951 cc",
                        4,
                        "13.00 kmpl",
                        "Ford",
                        2020,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        104,
                        "BMW M-5 Power",
                        200,
                        "4395 cc",
                        5,
                        "9.12 kmpl",
                        "BMW",
                        2019,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        105,
                        "Mercedes-Benz SLS",
                        240,
                        "6208 cc",
                        4,
                        "10.07 kmpl",
                        "Diamler AG",
                        2020,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        106,
                        "Toyota Avalon",
                        205,
                        "3456 cc",
                        5,
                        "32 mpg",
                        "Toyota",
                        2021,
                        "Gasoline"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        107,
                        "Nissan Altima",
                        200,
                        "1998 cc",
                        5,
                        "39 mpg",
                        "Nissan",
                        2020,
                        "Gasoline"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        108,
                        "Ford Explorer",
                        190,
                        "2296 cc",
                        5,
                        "42.08 mpg",
                        "Ford",
                        2020,
                        "Gasoline"
                    )
                )

                db.vehicleDAO().insert(
                    Vehicle(
                        201,
                        "KTM 200 DUKE",
                        120,
                        "199.5 cc",
                        2,
                        "35 kmpl",
                        "KTM/Bajaj",
                        2021,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        202,
                        "SUZUKI GIXXER",
                        125,
                        "155 cc",
                        2,
                        "38-55 kmpl",
                        "Suzuki",
                        2021,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        203,
                        "ROYAL ENFIELD Himalyan",
                        110,
                        "411 cc",
                        2,
                        "36.80 kmpl",
                        "Royal Enfield ",
                        2020,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        204,
                        "HONDA HORNET 2.0",
                        125,
                        "184.4 cc",
                        2,
                        "57.35 kmpl",
                        "Honda",
                        2020,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        205,
                        "YAMAHA MT 15 V2",
                        110,
                        "155 cc",
                        2,
                        "56.87 kmpl",
                        "Yamaha",
                        2020,
                        "Petrol"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        206,
                        "LECTRIX LXS",
                        100,
                        "124.3 cc",
                        2,
                        "89 km/charge",
                        "Lectrix",
                        2021,
                        "Electric"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        207,
                        "HERO VIDA V1",
                        90,
                        "155 cc",
                        2,
                        "165 km/charge",
                        "Hero",
                        2021,
                        "Electric"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        208,
                        "HONDA ACTIVA 6G",
                        80,
                        "109.5 cc",
                        2,
                        "60kmpl",
                        "Honda",
                        2020,
                        "Petrol"
                    )
                )

                db.vehicleDAO().insert(
                    Vehicle(
                        301,
                        "Toyota Hilux",
                        200,
                        "2755 cc",
                        5,
                        "10 kmpl",
                        "Toyota",
                        2021,
                        "Diesel"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        302,
                        "ISUZU D-MAX",
                        190,
                        "2499 cc",
                        2,
                        "12.40 kmpl",
                        "Isuzu Motors",
                        2021,
                        "Diesel"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        303,
                        "MAHINDRA BOLERO Camper",
                        210,
                        "2523 cc",
                        2,
                        "14.30 kmpl",
                        "Mahindra",
                        2020,
                        "Diesel"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        304,
                        "BHARATBENZ 2823R",
                        195,
                        "3900 cc",
                        2,
                        "5 kmpl",
                        "Daimler Truck AG",
                        2020,
                        "Diesel"
                    )
                )
                db.vehicleDAO().insert(
                    Vehicle(
                        305,
                        "ISUZU V-CROSS",
                        200,
                        "2499 cc",
                        5,
                        "14.40 kmpl",
                        "Isuzu Motors",
                        2021,
                        "Diesel"
                    )
                )

            } catch (e:InterruptedException) {
                e.printStackTrace();
            }
        }


        btn.setOnClickListener {
            if (edtemail.text.toString() == "" || edtpass.text.toString() == "") {
                Toast.makeText(
                    applicationContext,
                    "Please enter email and password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val foundName: String =
                    db.contactDAO().checkcontact(edtemail.text.toString(), edtpass.text.toString())
                if ((db.contactDAO().findcontact(edtemail.text.toString())) == 0){
                    Toast.makeText(applicationContext, "Email not registered", Toast.LENGTH_SHORT)
                        .show()
                }
                else if ((db.contactDAO().checkpass(edtemail.text.toString()))!= edtpass.text.toString()){
                    Toast.makeText(applicationContext, "Wrong Password!", Toast.LENGTH_SHORT)
                        .show()
                }
                else{
                    Toast.makeText(applicationContext, "Welcome "+foundName, Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("emailId",edtemail.text.toString())
                    startActivity(intent)
                    this.finish()
                }

            }
        }
    }
}