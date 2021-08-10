package com.tamara.scientificcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var buttonPlus:Button
    lateinit var buttonMinus:Button
    lateinit var buttonMultiplication:Button
    lateinit var buttonDiv:Button
    lateinit var buttonResult:Button
    lateinit var textNumber: TextView
    lateinit var buttonClear:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        addCallBacks()
    }

    private fun addCallBacks() {
        buttonClear.setOnClickListener {
            clearInput()


        }
    }

    private fun initView()
{
    buttonPlus=findViewById(R.id.button_plus)
    buttonMinus=findViewById(R.id.button_minus)
    buttonMultiplication=findViewById(R.id.button_multi)
    buttonDiv=findViewById(R.id.button_div)
    buttonResult=findViewById(R.id.button_result)
    textNumber=findViewById(R.id.text_number)
    buttonClear =findViewById(R.id.button_clear)
}

    fun onClickNumber(v: View)
    {val newDigit=(v as Button).text.toString()
        val oldDigit=textNumber.text.toString()
        val newTextNumber=oldDigit+newDigit
        textNumber.text=newTextNumber


    }
    fun clearInput(){
        textNumber.text=""


    }
}