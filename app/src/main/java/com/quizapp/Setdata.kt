package com.quizapp


import java.text.DateFormat
import java.text.SimpleDateFormat

object Setdata {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

fun getQuestions(): ArrayList<question_Data> {
        val questionsList = ArrayList<question_Data>()

        var q1 = question_Data(
            ques = "Guess the day :",
            id = 1,
            questiondate = getdate(),
            optone = " Sunday ",
            opttwo = "Tuesday",
            optthree ="Thursday",
            optfour = "Friday",
            correct_ans = 1
        )
        val q2 = question_Data(
            ques = "Guess the day :",
            id = 2,
            questiondate = getdate(),
            optone = "saturday",
            opttwo = "Tuesday",
            optthree = "Monday",
            optfour="Friday",
            correct_ans = 3

        )
        val q3 = question_Data(
            ques = "Guess the day :",
            id = 3,
            questiondate = getdate(),
            optone = "Monday",
            opttwo = "Tuesday",
            optthree = "wednesday",
            optfour = "Friday",
            correct_ans = 4

        )
        val q4 = question_Data(
            ques = "Guess the day :",
            id = 4,
            questiondate = getdate(),
            optone = "Monday",
            opttwo = "Tuesday",
            optthree = "Thursday",
            optfour = "Friday",
            correct_ans = 1

        )
        val q5 = question_Data(
            ques = "Guess the day :",
            id = 5,
            questiondate = getdate(),
            optone = "Monday",
            opttwo = "Tuesday",
            optthree = "Saturday",
            optfour = "Friday",
            correct_ans = 3

        )
        val q6 = question_Data(
            ques = "Guess the day :",
            id = 6,
            questiondate = getdate(),
            optone = "friday",
            opttwo = "Tuesday",
            optthree = "Thursday",
            optfour = "Wednesday",
            correct_ans = 1

        )
        val q7 = question_Data(
            ques = "Guess the day :",
            id = 7,
            questiondate = getdate(),
            optone = "Monday",
            opttwo = "Tuesday",
            optthree = "Thursday",
            optfour = "Friday",
            correct_ans = 2

        )
        val q8 = question_Data(
            ques = "Guess the day :",
            id = 8,
            questiondate = getdate(),
            optone = "Monday",
            opttwo = "Tuesday",
            optthree = "Thursday",
            optfour = "Friday",
            correct_ans = 3

        )
        val q9 = question_Data(
            ques = "Guess the day :",
            id = 9,
            questiondate = getdate(),
            optone = "Monday",
            opttwo = "Tuesday",
            optthree = "Thursday",
            optfour = "Friday",
            correct_ans = 1

        )
        val q10 = question_Data(
            ques = "Guess the day :",
            id = 10,
            questiondate = getdate(),
            optone = "Monday",
            opttwo = "Tuesday",
            optthree = "Thursday",
            optfour = "Friday",
            correct_ans = 4

        )
        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        questionsList.add(q7)
        questionsList.add(q8)
        questionsList.add(q9)
        questionsList.add(q10)

        return questionsList
    }

    private fun getdate(): String {

        var yrandom: Int = (1850..2020).random()
        var mrandom: Int = (1..12).random()
        var drandom: Int = 0
        if (mrandom == 2) {
            if (isLeapyear(yrandom)) run {
                drandom = (1..29).random()
            }
            else {
                drandom = (1..28).random()
            }
        } else if (mrandom % 2 == 1 && mrandom < 8 || mrandom % 2 == 0 && mrandom > 7) {
            drandom = (1..31).random()
        } else {
            drandom = (1..30).random()
        }

        var str = ("$drandom/$mrandom/$yrandom")
        getday(str)

        return ("$drandom/$mrandom/$yrandom")

}
    fun getday(qdate:String): String {
        var input_date = qdate
        var format1 = SimpleDateFormat("dd/MM/yyyy")
        var dt1 = format1.parse(input_date.toString())
        var format2: DateFormat = SimpleDateFormat("EEEE")
        var finalDay = format2.format(dt1)
        return finalDay }

    fun isLeapyear(yr: Int): Boolean
    { return yr % 4 == 0 && yr % 100 != 0 || yr % 400 == 0 }
}


