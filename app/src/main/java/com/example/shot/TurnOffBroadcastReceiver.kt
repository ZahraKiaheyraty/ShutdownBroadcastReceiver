package com.example.shot

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.shot.Constance.MY_PREFS_NAME
import com.example.shot.Constance.TIME_PREFS

class TurnOffBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1!!.action == Intent.ACTION_SHUTDOWN) {
            val editor: SharedPreferences.Editor =
                p0!!.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit()
            editor.putString(TIME_PREFS, (System.currentTimeMillis() / 1000).toString())
            editor.apply()
        }
    }
}