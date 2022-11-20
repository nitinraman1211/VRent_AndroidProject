package com.example.vrent

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vrent.Model.Contact
import com.example.vrent.Model.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.math.exp

class SignupActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val firstName = findViewById<EditText>(R.id.firstName)
        val middleName = findViewById<EditText>(R.id.middleName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val email = findViewById<EditText>(R.id.email)
        val drivingLicense = findViewById<EditText>(R.id.license)
        val expiry_date = findViewById<EditText>(R.id.expiry_date_underline)
        val dob = findViewById<EditText>(R.id.dob_field_underline)
        val phone = findViewById<EditText>(R.id.phoneNumber)
        val street = findViewById<EditText>(R.id.street)
        val city = findViewById<EditText>(R.id.city)
        val postal_code = findViewById<EditText>(R.id.postalCode)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword)
        val registerBtn = findViewById<Button>(R.id.register)
        val logintxt = findViewById<TextView>(R.id.login)

        var exp_d = findViewById<TextView>(R.id.expiryDate)
        var dob_t = findViewById<TextView>(R.id.dob)

        exp_d.setOnClickListener{
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog = DatePickerDialog(
                    this,
                    { view, year, monthOfYear, dayOfMonth ->
                        val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                        exp_d.setText(""+dat)
                    },
                    year,
                    month,
                    day
                )
                datePickerDialog.show()

        }

        dob_t.setOnClickListener {
           val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                        dob_t.setText(""+dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        database =
            Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "mycontact4")
                .allowMainThreadQueries().build()

        logintxt.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            this.finish()
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

        registerBtn.setOnClickListener {
            if (firstName.text.toString().isEmpty() || lastName.text.toString().isEmpty() || email.text.toString().isEmpty() || drivingLicense.text.toString().isEmpty() || exp_d.text=="YYYY-MM-DD" || dob_t.text == "YYYY-MM-DD"
                || phone.text.toString().isEmpty() || street.text.toString().isEmpty() || city.text.toString().isEmpty()|| postal_code.text.toString().isEmpty() || password.text.toString().isEmpty() || confirmPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(
                    applicationContext,
                    "Please fill all required Filled",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (password.text.toString() != confirmPassword.text.toString()) {
                    Toast.makeText(
                        applicationContext,
                        "Password and Confirm Password Not Matching!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if ((database.contactDAO().findcontact(email.text.toString())) != 0) {
                        Toast.makeText(
                            applicationContext,
                            "Email already registered!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        var fullName: String = ""
                        if (middleName.text.toString().isEmpty()) fullName = firstName.text.toString() + " " + lastName.text.toString()
                        else fullName = firstName.text.toString() + " " + middleName.text.toString() + " " + lastName.text.toString()
                        GlobalScope.launch(Dispatchers.IO) {
                            database.contactDAO().insert(
                                Contact(
                                    fullName,
                                    email.text.toString(),
                                    drivingLicense.text.toString(),
                                    exp_d.text.toString(),
                                    dob_t.text.toString(),
                                    phone.text.toString().toLong(),
                                    street.text.toString(),
                                    city.text.toString(),
                                    postal_code.text.toString().toInt(),
                                    password.text.toString()
                                )
                            )
                        }
                        Toast.makeText(
                            applicationContext,
                            "Registered Successfully!!",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }
        }
    }


}