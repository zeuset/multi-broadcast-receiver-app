package com.zeus.appsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

class SeverityLevelReceiver : BroadcastReceiver() {

    private val TAG = this::class.java.simpleName

    fun register(context: Context) {
        Log.i(TAG, "register in app sender")
        context.registerReceiver(this, IntentFilter())
    }

    fun unRegister(context: Context) {
        Log.i(TAG, "unRegister in app sender")
        context.unregisterReceiver(this)
    }

    fun testSendBroadcast(context: Context, s: String) {
        try {
            val intent = Intent()
            intent.action = "com.zeus.receiver.severity"
            intent.putExtra("severity_level", s)
//            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            context.sendBroadcast(intent, "com.zeus.appsender.signPermission")
            Log.i(TAG, "sendBroadcast: ")
        } catch (e: Exception) {
            Log.e(TAG, "Exception while sending broadcast : $e")
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) = Unit
}