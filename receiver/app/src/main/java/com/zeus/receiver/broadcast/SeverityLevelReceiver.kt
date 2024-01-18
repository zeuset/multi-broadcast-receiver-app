package com.zeus.receiver.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

class SeverityLevelReceiver : BroadcastReceiver() {
    
    private val TAG = this::class.java.simpleName

    fun register(context: Context) {
        Log.i(TAG, "register in app receiver")
        context.registerReceiver(this, IntentFilter().apply {
            addAction("com.zeus.receiver.severity")
        }, Context.RECEIVER_EXPORTED)
    }

    fun unRegister(context: Context) {
        Log.i(TAG, "unRegister in app receiver")
        context.unregisterReceiver(this)
    }

    override fun onReceive(context: Context, intent: Intent) {
        try {
            val severityLevel = intent.getStringExtra("severity_level")
            Log.i(TAG, "App receive with data: $severityLevel")
        } catch (e: Exception) {
            Log.e(TAG, "Error from app receiver: $e")
        }
    }
}
