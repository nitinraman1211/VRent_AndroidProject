package com.example.vrent.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.vrent.CarModel
import com.example.vrent.R

class CarAdapter(var mCtx: Context, var resources:Int, var items:List<CarModel>):
    ArrayAdapter<CarModel>(mCtx,resources,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)


        var imgView: ImageView = view.findViewById(R.id.ImgCar)
        var txtView: TextView = view.findViewById(R.id.CarName)
        var txtPrice: TextView = view.findViewById(R.id.txtPrice)

        val mItem: CarModel = items[position]
        imgView.setImageDrawable(mCtx.resources.getDrawable(mItem.resource))
        txtView.text = mItem.Name
        txtPrice.text = mItem.price

        return view

    }
}