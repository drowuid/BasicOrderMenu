package com.example.ex12restorder

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex12restorder.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val orderList = intent.getStringArrayListExtra("order")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putStringArrayListExtra("order", orderList)
            startActivity(intent)
            finish()
        }, 4000)
    }
}
