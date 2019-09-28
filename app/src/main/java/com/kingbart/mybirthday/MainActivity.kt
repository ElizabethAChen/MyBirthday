package com.kingbart.mybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        birthdayChecker.setOnClickListener {buClickEvent()}
    }

    fun buClickEvent(){
        val userName: String = inputName.text.toString()
        val userDOBM:String = inputBdayMonth.text.toString()
        val userDOBD:String = inputBdayDay.text.toString()
        val userDOB = userDOBM.plus(userDOBD)
        val fixedMonth: Int = Calendar.getInstance().get(Calendar.MONTH) +1
        val month:String= fixedMonth.toString()
        val day:String=Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
        val currentDate = month.plus(day)
        when {
            userName.isEmpty() -> userMessage.text = ("You did not enter your name")
            userDOBM.isEmpty() -> userMessage.text = ("You did not enter you birthday month")
            userDOBD.isEmpty() -> userMessage.text = ("You did not enter you birthday day")
            else -> if (userDOB == currentDate) {
                userMessage.text = "Congrats, $userName! Happy Birthday!"
                val resId = R.drawable.birthdaycake
                imageView.setImageResource(resId)
            } else {
                userMessage.text = "Sorry, $userName! It's not your birthday"
            }
        }
    }
}