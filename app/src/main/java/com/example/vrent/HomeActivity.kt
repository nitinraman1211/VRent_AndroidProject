package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {
    var eid :String? = ""
    lateinit var myViewPageAdapter: MyViewPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager: ViewPager = findViewById(R.id.view_pager_2)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val profileImg = findViewById<ImageView>(R.id.profile)

        myViewPageAdapter = MyViewPageAdapter(supportFragmentManager)
        viewPager.setAdapter(myViewPageAdapter)

        val bundle : Bundle? = intent.extras
        eid = bundle?.getString("emailId")

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        tabLayout.setupWithViewPager(viewPager)

        registerForContextMenu(profileImg)


    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        getMenuInflater().inflate(R.menu.menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.getItemId()){
            R.id.view_profile-> {
                val intent = Intent(this,view_Profile::class.java)
                intent.putExtra("emailId",eid)
                startActivity(intent)
            }
            R.id.bookingHistory->{
                val intent = Intent(this,Booking_History::class.java)
                intent.putExtra("emailId",eid)
                startActivity(intent)
            }
            R.id.logout-> {
                this.finish()
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)


            }
        }
        return super.onContextItemSelected(item)
    }
}