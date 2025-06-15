package com.example.ap2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Question2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        val scoreFromQ1 = intent.getIntExtra("score", 0)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup2)
        val btnNext = findViewById<Button>(R.id.btnNext2)

        btnNext.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Selecione uma opção", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val scoreQ2 = when (selectedId) {
                R.id.rb4 -> 0
                R.id.rb5 -> 1
                R.id.rb6 -> 2
                else -> 0
            }

            val totalScore = scoreFromQ1 + scoreQ2

            val intent = Intent(this, Question3Activity::class.java)
            intent.putExtra("score", totalScore)
            startActivity(intent)
        }
    }
}