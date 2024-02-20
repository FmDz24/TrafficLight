package com.example.trafficlight

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.Timer
import java.util.TimerTask

class MainActivity : Activity() {

    var imSemafor: ImageView? = null
    var counter:Int = 0
    var timer: Timer? = null
    var is_run = false

    var ImageArray: IntArray = intArrayOf(R.drawable.sr, R.drawable.sy, R.drawable.sg)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imSemafor = findViewById(R.id.semafor)

    }
    fun onClickStartStop(view: View) {
        view as ImageButton
        if (!is_run) {

            startStop()

            view.setImageResource(R.drawable.rb)
            is_run = true
        }

        else
        {
            imSemafor?.setImageResource(R.drawable.sss)
            view.setImageResource(R.drawable.bg)
            timer?.cancel()
            is_run = false
            counter = 0
        }

        imSemafor?.setImageResource(R.drawable.sss)
    }

    fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask(){
            override fun run() {
               runOnUiThread{
                   imSemafor?.setImageResource(ImageArray[counter])
                   counter++
                   if (counter == 3)counter = 0
               }

            }

        }, 0, 1000)


    }
}