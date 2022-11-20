package com.example.vrent

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.vrent.Adapter.CarAdapter

class Cars_Fragment_Activity : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view  = inflater?.inflate(R.layout.activity_cars_fragment,container,false)


        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var gridview : GridView = view.findViewById(R.id.gridCar1)
        var list = mutableListOf<CarModel>()

        list.add(CarModel("BMW X4 Sports","$210/day",R.drawable.bmw_car_img))
        list.add(CarModel("Audi A7 2018","$190/day",R.drawable.audi))
        list.add(CarModel("Ford Mustang GT","$220/day",R.drawable.ford_mustang))
        list.add(CarModel("BMW M5 G-Power","$200/day",R.drawable.bmw_m5_img))
        list.add(CarModel("Mercedes-Benz SLS","$240/day",R.drawable.mercedes))
        list.add(CarModel("Toyota Avalon","$205/day",R.drawable.toyota_avalon))
        list.add(CarModel("Nissan Altima","$200/day",R.drawable.nissan_altima))
        list.add(CarModel("Ford Explorer","$190/day",R.drawable.ford_ex))


        gridview.adapter = activity?.let { CarAdapter(it,R.layout.carrow,list) }
        var imgList = arrayListOf<Int>(R.drawable.bmw_car_img,R.drawable.audi,R.drawable.ford_mustang,R.drawable.bmw_m5_img,R.drawable.mercedes,R.drawable.toyota_avalon,R.drawable.nissan_altima,R.drawable.ford_ex)
        gridview.setOnItemClickListener{adapterView,view,i, l->
            val intent = Intent(getActivity(),VehicleInfo::class.java)
            intent.putExtra("vehicleId",100+i+1)
            intent.putExtra("vehicleImg",imgList[i])
            startActivity(intent)
        }




    }




}