package com.example.shot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.IntentFilter
import android.widget.TextView
import com.example.ShutdownReceiver.R
import com.example.shot.Constance.DEFAULT_PREFS
import com.example.shot.Constance.MY_PREFS_NAME
import com.example.shot.Constance.TIME_PREFS

class MainActivity : AppCompatActivity() {
    lateinit var textTime: TextView
    private lateinit var mReceiver: TurnOffBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        textTime.text =
            getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).getString(TIME_PREFS, DEFAULT_PREFS)

    }

    private fun init() {
        textTime = findViewById(R.id.txtTime)
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(Intent.ACTION_SHUTDOWN)
        mReceiver = TurnOffBroadcastReceiver()
        registerReceiver(mReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        this.unregisterReceiver(mReceiver);
    }
}