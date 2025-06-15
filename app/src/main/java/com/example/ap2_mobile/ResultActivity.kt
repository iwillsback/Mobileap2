package com.example.ap2_mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score", 0)
        val textResult = findViewById<TextView>(R.id.textResult)

        val profile = when (score) {
            in 0..3 -> "Conservador"
            in 4..6 -> "Moderado"
            else -> "Dinâmico"
        }

        textResult.text = "Seu perfil de investidor é: $profile"

        findViewById<Button>(R.id.btnEmail).setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Meu Perfil de Investidor")
                putExtra(Intent.EXTRA_TEXT, "Meu perfil de investidor é: $profile")
            }
            startActivity(Intent.createChooser(emailIntent, "Enviar e-mail"))
        }
    }
}