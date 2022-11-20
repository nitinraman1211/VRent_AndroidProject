package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment

class Explore_Fragment_Activity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.activity_explore_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val carF = view.findViewById<CardView>(R.id.BMW)
        val bfrag = view.findViewById<CardView>(R.id.bfrag)
        val cfrag = view.findViewById<CardView>(R.id.cfrag)
        val dfrag = view.findViewById<CardView>(R.id.dfrag)
        carF.setOnClickListener{
            val intent = Intent(getActivity(),VehicleInfo::class.java)
            intent.putExtra("vehicleId",101)
            intent.putExtra("vehicleImg",R.drawable.bmw_car_img)
            startActivity(intent)
        }
        bfrag.setOnClickListener{
            val intent = Intent(getActivity(),VehicleInfo::class.java)
            intent.putExtra("vehicleId",201)
            intent.putExtra("vehicleImg",R.drawable.ktm_img)
            startActivity(intent)
        }
        cfrag.setOnClickListener{
            val intent = Intent(getActivity(),VehicleInfo::class.java)
            intent.putExtra("vehicleId",103)
            intent.putExtra("vehicleImg",R.drawable.ford_mustang)
            startActivity(intent)
        }
        dfrag.setOnClickListener{
            val intent = Intent(getActivity(),VehicleInfo::class.java)
            intent.putExtra("vehicleId",302)
            intent.putExtra("vehicleImg",R.drawable.isuzu_d_max)
            startActivity(intent)
        }


        super.onViewCreated(view, savedInstanceState)
    }
}