package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.vrent.Adapter.BikesAdapter
import com.example.vrent.Adapter.CarAdapter

class Bikes_Fragment_Activity :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.activity_bikes_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var gridview : GridView = view.findViewById(R.id.gridBikes1)
        var list = mutableListOf<BikeModel>()
        list.add(BikeModel("KTM 200 DUKE","$120/day",R.drawable.ktm_img))
        list.add(BikeModel("SUZUKI GIXXER","$125/day",R.drawable.suzuki_gixxer_img))
        list.add(BikeModel("ROYAL ENFIELD","$110/day",R.drawable.royal_enfield_img))
        list.add(BikeModel("HONDA HORNET 2.0","$125/day",R.drawable.honda_img))
        list.add(BikeModel("YAMAHA MT 15 V2","$110/day",R.drawable.yamaha_1))
        list.add(BikeModel("LECTRIX LXS","$100/day",R.drawable.letrix_img))
        list.add(BikeModel("HERO VIDA V1","$90/day",R.drawable.hero_img))
        list.add(BikeModel("HONDA ACTIVA 6G","$80/day",R.drawable.honda_activa6g_img))


        gridview.adapter = activity?.let { BikesAdapter(it,R.layout.bikerow,list) }

        var imgList = arrayListOf<Int>(R.drawable.ktm_img,R.drawable.suzuki_gixxer_img,R.drawable.royal_enfield_img,R.drawable.honda_img
            ,R.drawable.yamaha_1,R.drawable.letrix_img,R.drawable.hero_img,R.drawable.honda_activa6g_img)
        gridview.setOnItemClickListener{adapterView,view,i, l->
            val intent = Intent(getActivity(),VehicleInfo::class.java)
            intent.putExtra("vehicleId",200+i+1)
            intent.putExtra("vehicleImg",imgList[i])
            startActivity(intent)
        }
    }
}