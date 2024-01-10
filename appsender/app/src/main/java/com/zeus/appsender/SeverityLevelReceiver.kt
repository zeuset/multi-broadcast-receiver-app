package com.zeus.appsender

import android.content.*
import android.util.Log
import android.widget.Toast


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

            /**
             * Broadcast working on android 8 or higher with explicit broadcast.
             * 1st packageName
             * 2nd className
             *
            intent.component = ComponentName(
                "com.zeus.app_gen_json",
                "com.zeus.app_gen_json.broadcast.SeverityLevelReceiver"
            )
            */

            /**
             * Intent.FLAG_INCLUDE_STOPPED_PACKAGES:
             * Is a flag that tells the system that broadcasts should be sent even when the application is not running (stopped).
             *
             * Usage may affect application performance and security. (performance and battery consumption.)
             */
            intent.action = "com.zeus.receiver.severity"
            intent.putExtra("severity_level", s)
//            intent.setPackage("com.zeus.app_gen_json")
//            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            context.sendBroadcast(intent, "my.app.PERMISSION")
            Log.i(TAG, "sendBroadcast: ")
        } catch (e: Exception) {
            Log.e(TAG, "Exception while sending broadcast : $e")
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) = Unit
}