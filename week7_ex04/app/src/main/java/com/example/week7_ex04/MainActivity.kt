package com.example.week7_ex04

import android.os.Bundle
import android.widget.ImageView
import android.widget.ToggleButton
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
        val tbLight = findViewById<ToggleButton>(R.id.tb_light)
        val ivBg = findViewById<ImageView>(R.id.iv_bg)
        val lights = listOf(
            findViewById<ImageView>(R.id.iv_light1),
            findViewById<ImageView>(R.id.iv_light2),
            findViewById<ImageView>(R.id.iv_light3)
        )
        val offImgs = intArrayOf(R.drawable.light11, R.drawable.light12, R.drawable.light13)
        val onImgs = intArrayOf(R.drawable.light21, R.drawable.light22, R.drawable.light23)

        tbLight.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                ivBg.setImageResource(R.drawable.bg2)
                for (i in lights.indices) lights[i].setImageResource(onImgs[i])
            } else {
                ivBg.setImageResource(R.drawable.bg1)
                for (i in lights.indices) lights[i].setImageResource(offImgs[i])
            }
        }
    }
}