package com.example.ap2_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Question3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        val score = intent.getIntExtra("score", 0)
        val fragment = Question3Fragment.newInstance(score)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}