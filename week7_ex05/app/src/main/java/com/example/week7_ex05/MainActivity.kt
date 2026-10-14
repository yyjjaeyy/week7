package com.example.week7_ex05

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val swCat = findViewById<Switch>(R.id.sw_cat)
        val swLight = findViewById<Switch>(R.id.sw_light)
        val ivCat = findViewById<ImageView>(R.id.iv_cat)
        val ivLamp = findViewById<ImageView>(R.id.iv_lamp)
        val vDark = findViewById<View>(R.id.v_dark)

        swCat.setOnCheckedChangeListener { _, isChecked ->
            ivCat.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }

        swLight.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                ivLamp.setImageResource(R.drawable.light32)
                vDark.visibility = View.INVISIBLE
            } else {
                ivLamp.setImageResource(R.drawable.light31)
                vDark.visibility = View.VISIBLE
            }
        }
    }
}