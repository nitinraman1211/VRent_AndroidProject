package com.example.vrent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        val img = findViewById<ImageView>(R.id.imageView)
        val title = findViewById<TextView>(R.id.textView)
        val slogan = findViewById<TextView>(R.id.textView2)

        val topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        val bottommAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        img.setAnimation(topAnim)
        title.setAnimation(bottommAnim)
        slogan.setAnimation(bottommAnim)

        val thread = Thread(){

                try{
                    //sleep for 3 second
                    sleep(3000);

                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)


                    //Destroy splash activity
                    finish();
                } catch (e:InterruptedException) {
                    e.printStackTrace();
                }

            }
        thread.start()


        //start the thread

    }

    }

