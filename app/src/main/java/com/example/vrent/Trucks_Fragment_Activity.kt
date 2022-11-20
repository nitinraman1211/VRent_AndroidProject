package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.vrent.Adapter.CarAdapter
import com.example.vrent.Adapter.TruckAdapter

class Trucks_Fragment_Activity : Fragment() {
    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        return inflater!!.inflate(R.layout.activity_trucks_fragment,container,false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var gridview : GridView = view.findViewById(R.id.gridTruck1)
        var list = mutableListOf<TruckModel>()

        list.add(TruckModel("TOYOTA HILUX","$200/day",R.drawable.toyota_hilux))
        list.add(TruckModel("ISUZU D-MAX","$190/day",R.drawable.isuzu_d_max))
        list.add(TruckModel("MAHINDRA BOLERO","$210/day",R.drawable.mahindra_bolero_camper))
        list.add(TruckModel("BHARATBENZ 2823R","$195/day",R.drawable.bharat_benz_2823rt))
        list.add(TruckModel("ISUZU V-CROSS","$200/day",R.drawable.isuzu_v_cross))



        gridview.adapter = activity?.let { TruckAdapter(it,R.layout.truckrow,list) }

        var imgList = arrayListOf<Int>(R.drawable.toyota_hilux,R.drawable.isuzu_d_max,R.drawable.mahindra_bolero_camper,R.drawable.bharat_benz_2823rt
            ,R.drawable.isuzu_v_cross)
        gridview.setOnItemClickListener{adapterView,view,i, l->
            val intent = Intent(getActivity(),VehicleInfo::class.java)
            intent.putExtra("vehicleId",300+i+1)
            intent.putExtra("vehicleImg",imgList[i])
            startActivity(intent)
        }
    }

}