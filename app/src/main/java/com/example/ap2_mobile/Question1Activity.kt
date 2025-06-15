package com.example.ap2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Question1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
        val btnNext = findViewById<Button>(R.id.btnNext1)

        btnNext.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Selecione uma opção", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val score = when (selectedId) {
                R.id.rb1 -> 0
                R.id.rb2 -> 1
                R.id.rb3 -> 2
                else -> 0
            }

            val intent = Intent(this, Question2Activity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}