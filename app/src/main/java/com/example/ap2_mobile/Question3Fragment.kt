package com.example.ap2_mobile

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class Question3Fragment : Fragment() {

    companion object {
        fun newInstance(score: Int): Question3Fragment {
            val fragment = Question3Fragment()
            val args = Bundle()
            args.putInt("score", score)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question3, container, false)

        val editKnowledge = view.findViewById<EditText>(R.id.editKnowledge)
        val btnFinish = view.findViewById<Button>(R.id.btnFinish)

        btnFinish.setOnClickListener {
            val knowledgeText = editKnowledge.text.toString().lowercase()
            val previousScore = arguments?.getInt("score") ?: 0

            val finalScore = previousScore + when {
                "avançado" in knowledgeText -> 2
                "básico" in knowledgeText -> 1
                else -> 0
            }

            val intent = Intent(requireContext(), ResultActivity::class.java)
            intent.putExtra("score", finalScore)
            startActivity(intent)
        }

        return view
    }
}