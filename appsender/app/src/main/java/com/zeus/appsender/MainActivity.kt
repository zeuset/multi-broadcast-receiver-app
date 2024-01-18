package com.zeus.appsender

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zeus.appsender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val severityLevelReceiver by lazy { SeverityLevelReceiver() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        severityLevelReceiver.register(this)
        binding.btnSendBroadcast.setOnClickListener {
            severityLevelReceiver.testSendBroadcast(this, "Hello 2024")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        severityLevelReceiver.unRegister(this)
    }
}