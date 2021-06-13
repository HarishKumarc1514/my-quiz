package com.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Make ResultActivity full screen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Retrieve the data by intent
        val userName = intent.getStringExtra(Setdata.USER_NAME)
        val totalQuestions = intent.getIntExtra(Setdata.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Setdata.CORRECT_ANSWERS, 0)

        // Print the result for the user
        tvUsername.text = userName
        tvScore.text = "Your score is $correctAnswers"

        // Return to the main page
        buttonFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}