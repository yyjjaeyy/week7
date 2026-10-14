package com.example.week7_ex01

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
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
        val listener = ShellClickListener()
        findViewById<ImageButton>(R.id.btn_1).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.btn_2).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.btn_3).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.btn_4).setOnClickListener(listener)
    }
    inner class ShellClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            val ivShell = findViewById<ImageView>(R.id.iv_shell)
            when (v?.id) {
                R.id.btn_1 -> ivShell.setImageResource(R.drawable.answer1)
                R.id.btn_2 -> ivShell.setImageResource(R.drawable.answer2)
                R.id.btn_3 -> ivShell.setImageResource(R.drawable.answer3)
                R.id.btn_4 -> ivShell.setImageResource(R.drawable.answer4)
            }
            ivShell.visibility = View.VISIBLE

            if (v?.id == R.id.btn_2) {
                Toast.makeText(this@MainActivity, "맞았습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "틀렸습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}