package com.example.ex12restorder

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex12restorder.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val order = intent.getStringArrayListExtra("order") ?: arrayListOf()
        var total = 0

        for (item in order) {
            val itemView = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(0, 16, 0, 16)
            }

            val layoutParams = LinearLayout.LayoutParams(200, 200)
            layoutParams.setMargins(0, 0, 24, 0)

            val imageView = ImageView(this).apply {
                this.layoutParams = layoutParams
                setImageResource(
                    when (item) {
                        "Coffee" -> R.drawable.coffee
                        "Chocolate" -> R.drawable.chocolate
                        "Pizza" -> R.drawable.pizza
                        else -> 0
                    }
                )
                scaleType = ImageView.ScaleType.FIT_CENTER
            }

            val textView = TextView(this).apply {
                textSize = 20f
                setPadding(0, 60, 0, 0)
                val price = when (item) {
                    "Coffee" -> 2
                    "Chocolate" -> 3
                    "Pizza" -> 8
                    else -> 0
                }
                total += price
                text = "$item - €$price"
            }

            itemView.addView(imageView)
            itemView.addView(textView)
            binding.orderItemsLayout.addView(itemView)
        }

        binding.totalText.text = "Total: €$total"
    }
}


