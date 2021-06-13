package com.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var myCurrentPos: Int = 1
    private var questionslist: ArrayList<question_Data>? = null
    private var mySelectOptPos: Int = 0
    private var myCrrtAns: Int = 0
    private var myUsername: String? = null
//    val yrandom = (1800..2020).random()
//    val mrandom = (1..12).random()
//    val drandom = (1..31).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        myUsername = intent.getStringExtra(Setdata.USER_NAME)
        questionslist = Setdata.getQuestions()

        setQuestion()

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        next_button.setOnClickListener(this)
//        q_date.text = drandom.toString()+"/"+mrandom.toString()+"/"+yrandom.toString()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.opt1 -> {selectedOptionView(opt1, 1) }
            R.id.opt2 -> {selectedOptionView(opt2, 2) }
            R.id.opt3 -> {selectedOptionView(opt3, 3) }
            R.id.opt4 -> {selectedOptionView(opt4, 4) }
            R.id.next_button -> {
                if (mySelectOptPos == 0) {
                    myCurrentPos++
                    when {
                        myCurrentPos <= questionslist!!.size -> {
                             setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Setdata.USER_NAME, myUsername)
                            intent.putExtra(Setdata.CORRECT_ANSWERS, myCrrtAns)
                            intent.putExtra(Setdata.TOTAL_QUESTIONS, questionslist!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                else {
                    val question = questionslist?.get(myCurrentPos - 1)
                    if (question!!.correct_ans != mySelectOptPos) {
                        answerView(mySelectOptPos, R.drawable.wrongop)

                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Setdata.USER_NAME, myUsername)
                        intent.putExtra(Setdata.CORRECT_ANSWERS, myCrrtAns)
                        intent.putExtra(Setdata.TOTAL_QUESTIONS, questionslist!!.size)
                        startActivity(intent)
                        finish()
                    } else {
                        myCrrtAns++
                    }
                    answerView(question.correct_ans, R.drawable.correctop)
                    if (myCurrentPos != questionslist!!.size) {
                        next_button.text = getString(R.string.nextQuestionButtonText)
                    }
                    if(mySelectOptPos == null)
                        next_button.visibility = View.INVISIBLE
                    // Reset the selected option
                    mySelectOptPos = 0
                }
            }
        }
    }

    private fun setQuestion() {

        val question = questionslist!![myCurrentPos - 1]

        defaultOptionsView()

        if (myCurrentPos == questionslist!!.size) {
           next_button.text = getString(R.string.submitButtonText)
        }

        q_text.text = question.ques
        q_date!!.text= question.questiondate
        opt1.text=question.optone
        opt2.text = question.opttwo
        opt3.text = question.optthree
        opt4.text = question.optfour

    }


    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        options.add(0, opt1)
        options.add(1, opt2)
        options.add(2, opt3)
        options.add(3, opt4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defaultop
            )
        }
    }

    // Function to change the background color of the correct and wrong answer
    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {

            1 -> { opt1.background = ContextCompat.getDrawable(
                    this, drawableView) }

            2 -> { opt2.background = ContextCompat.getDrawable(
                    this, drawableView ) }

            3 -> { opt3.background = ContextCompat.getDrawable(
                    this, drawableView) }

            4 -> { opt4.background = ContextCompat.getDrawable(
                    this, drawableView) }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mySelectOptPos = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.seletctedop
        )
    }

}