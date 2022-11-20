package com.example.vrent

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.vrent.Model.Booking
import com.example.vrent.Model.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class Booking_Vehicle : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_vehicle)

        val dfirstName = findViewById<EditText>(R.id.firstName)
        val dlastName = findViewById<EditText>(R.id.lastName)
        val radiog = findViewById<RadioGroup>(R.id.mrMsTitle)
        val rid = radiog.checkedRadioButtonId
        val rd:RadioButton = findViewById(rid)
        val demail = findViewById<EditText>(R.id.email)
        val dNumber = findViewById<EditText>(R.id.phoneNumber)
        val pickDate = findViewById<TextView>(R.id.pickupDate)
        val returnDate = findViewById<TextView>(R.id.returnDate)
        val pickTime = findViewById<TextView>(R.id.pickupTime)
        val returnTime = findViewById<TextView>(R.id.returnTime)

        val bookVehicle = findViewById<Button>(R.id.continueBooking)

        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {finish()}
        database =
            Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "mycontact4")
                .allowMainThreadQueries().build()

        pickDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    pickDate.setText("" + dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
        pickTime.setOnClickListener {
            val mTimePicker: TimePickerDialog
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute = mcurrentTime.get(Calendar.MINUTE)

            mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    pickTime.setText(String.format("%d : %d", hourOfDay, minute))
                }
            }, hour, minute, false)

            mTimePicker.show()

        }

        returnDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    returnDate.setText("" + dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
        returnTime.setOnClickListener {
            val mTimePicker: TimePickerDialog
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute = mcurrentTime.get(Calendar.MINUTE)

            mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    returnTime.setText(String.format("%d : %d", hourOfDay, minute))
                }
            }, hour, minute, false)

            mTimePicker.show()

        }
        val bundle: Bundle? = intent.extras
        val resid: Int? = bundle?.getInt("vehicleId")
        val vehicle: Int? = bundle?.getInt("vehicleImg")
        val insurance: String? = bundle?.getString("insurance")
        val current = LocalDate.now()
        val insAmt: Int
        if (insurance == "None") {
            insAmt = 0
        } else if (insurance == "Basic") {
            insAmt = 15
        } else {
            insAmt = 25
        }


        bookVehicle.setOnClickListener {
            if (dfirstName.text.toString() == "" || dlastName.text.toString() == "" || demail.text.toString() == "" || dNumber.text.toString() == "") {
                Toast.makeText(this,"Please fill all required filled!!",Toast.LENGTH_SHORT).show()
            } else {
                val mDateFormat = SimpleDateFormat("dd-mm-yyyy")
                val mDate11 = mDateFormat.parse(pickDate.text.toString())
                val mDate22 = mDateFormat.parse(returnDate.text.toString())
                val mDifference = kotlin.math.abs(mDate11.time - mDate22.time)
                val differenceDates = mDifference / (24 * 60 * 60 * 1000)
                val dayDifference = differenceDates.toString()
                var vprice: Int
                val id: Int = generateID(100, 9999)
                if (resid != null) {
                    vprice = database.vehicleDAO().getVehiclePrice(resid)
                    GlobalScope.launch(Dispatchers.IO) {
                        database.bookingDAO().insert(
                            Booking(
                                id,
                                current.toString(),
                                pickDate.text.toString() + " " + pickTime.text.toString(),
                                returnDate.text.toString() + " " + returnTime.text.toString(),
                                rd.text.toString() + " " + dfirstName.text.toString() + " " + dlastName.text.toString(),
                                demail.text.toString(),
                                dNumber.text.toString().toInt(),
                                insurance.toString(),
                                (dayDifference.toLong() + 1) * vprice + insAmt,
                                resid
                            )
                        )
                    }


                }
                val intent = Intent(this, Booking_Complete::class.java)
                intent.putExtra("vehicleId", resid)
                intent.putExtra("vehicleImg", vehicle)
                intent.putExtra("insurance", insurance)
                intent.putExtra("bookingId", id)
                intent.putExtra("daydiff", dayDifference)
                startActivity(intent)
            }
        }
    }

    private fun generateID(start: Int, end: Int): Int {
        val rnd = Random()
        val bound = end % 100
        return rnd.nextInt(bound) + start
    }

}