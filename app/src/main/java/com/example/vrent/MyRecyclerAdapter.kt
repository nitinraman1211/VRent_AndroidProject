package com.example.vrent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.vrent.Model.BookingHistory
import org.w3c.dom.Text

class MyRecyclerAdapter(context : Context,list:MutableList<BookingHistory>): RecyclerView.Adapter<MyRecyclerAdapter.MyHolder>() {
    var context : Context
    var list:MutableList<BookingHistory>

    class MyHolder(view : View) : RecyclerView.ViewHolder(view){
        var Bid : TextView
        var Dname :TextView
        var Demail:TextView
        var Dphone:TextView
        var pdate:TextView
        var rdate:TextView
        var vname:TextView
        var pamt:TextView

        init {
            Bid = view.findViewById(R.id.bookingId1)
            Dname = view.findViewById(R.id.driverName1)
            Demail = view.findViewById(R.id.emailId1)
            Dphone = view.findViewById(R.id.Phone1)
            pdate = view.findViewById(R.id.pickUpdate1)
            rdate = view.findViewById(R.id.returnDate1)
            vname = view.findViewById(R.id.vehicleName1)
            pamt = view.findViewById(R.id.payAmount1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.bookingrow,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       holder.Bid.text = list[position].BookingId
        holder.Dname.text = list[position].DName
        holder.Demail.text = list[position].Demail
        holder.Dphone.text = list[position].Dphone
        holder.Dname.text = list[position].DName
        holder.pdate.text = list[position].pickDate
        holder.rdate.text = list[position].returnDate
        holder.vname.text = list[position].VehicleName
        holder.pamt.text = "$"+list[position].TotalAmt.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
    init {
        this.context = context
        this.list = list
    }
}