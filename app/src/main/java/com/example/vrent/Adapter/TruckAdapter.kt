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
import com.example.vrent.TruckModel

class TruckAdapter(var mCtx: Context, var resources:Int, var items:List<TruckModel>):
    ArrayAdapter<TruckModel>(mCtx,resources,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)


        var imgView: ImageView = view.findViewById(R.id.ImgTruck)
        var txtView: TextView = view.findViewById(R.id.TruckName)
        var txtPrice: TextView = view.findViewById(R.id.txtTPrice)

        val mItem: TruckModel = items[position]
        imgView.setImageDrawable(mCtx.resources.getDrawable(mItem.resource))
        txtView.text = mItem.Name
        txtPrice.text = mItem.price

        return view

    }
}