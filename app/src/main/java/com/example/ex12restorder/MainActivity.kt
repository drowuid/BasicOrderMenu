package com.example.ex12restorder

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex12restorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOrder.setOnClickListener {
            val selectedItems = ArrayList<String>()

            if (binding.checkboxCoffee.isChecked) selectedItems.add("Coffee")
            if (binding.checkboxChocolate.isChecked) selectedItems.add("Chocolate")
            if (binding.checkboxPizza.isChecked) selectedItems.add("Pizza")

            val intent = Intent(this, SplashActivity::class.java)
            intent.putStringArrayListExtra("order", selectedItems)
            startActivity(intent)
        }
    }
}