package com.example.vrent

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPageAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm) {

    val mFragmentTitleList = arrayOf("Explore","Cars","Bikes","Trucks")
    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return Explore_Fragment_Activity()
            1->return Cars_Fragment_Activity()
            2->return Bikes_Fragment_Activity()
            3->return Trucks_Fragment_Activity()
            else-> return Explore_Fragment_Activity()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }


    override fun getCount(): Int {
        return 4
    }


}