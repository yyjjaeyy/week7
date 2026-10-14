package com.example.week7_ex02

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
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
        checkBoxes = listOf(
            findViewById(R.id.cb_1), findViewById(R.id.cb_2),
            findViewById(R.id.cb_3), findViewById(R.id.cb_4)
        )

        // 체크박스 이벤트: 체크하면 이름 토스트
        for (i in checkBoxes.indices) {
            checkBoxes[i].setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "${names[i]}을(를) 선택했습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val btnResult = findViewById<Button>(R.id.btn_result)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        btnResult.setOnClickListener {
            if (!isResultShown) {
                // 정답: 소방차 + 장갑
                val correct = checkBoxes[0].isChecked && !checkBoxes[1].isChecked &&
                        !checkBoxes[2].isChecked && checkBoxes[3].isChecked
                tvResult.text = if (correct) "맞았습니다" else "틀렸습니다"
                btnResult.text = "재시작하기"
                isResultShown = true
            } else {
                for (cb in checkBoxes) cb.isChecked = false
                tvResult.text = "소방관의 용품을 선택해주세요"
                btnResult.text = "결과보기"
                isResultShown = false
            }
        }
    }
    private lateinit var checkBoxes: List<CheckBox>
    private val names = listOf("소방차", "믹서기", "청진기", "장갑")
    private var isResultShown = false
}