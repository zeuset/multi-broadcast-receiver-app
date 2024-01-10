package com.zeus.receiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zeus.receiver.broadcast.SeverityLevelReceiver

class MainActivity : AppCompatActivity() {

    private val severityLevelReceiver by lazy { SeverityLevelReceiver() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        severityLevelReceiver.register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        severityLevelReceiver.unRegister(this)
    }
}