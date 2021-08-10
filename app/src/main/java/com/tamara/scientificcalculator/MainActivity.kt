package com.tamara.scientificcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.tamara.scientificcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    var lastNumber:Double=0.0
    var currentOperation:Operation?=null
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addCallBacks()

    }

    private fun addCallBacks() {
        buttonClear.setOnClickListener {
            clearInput()
        }
        buttonPlus.setOnClickListener { prepareOperation(Operation.plus) }
        buttonMinus.setOnClickListener { prepareOperation(Operation.minus) }
        buttonMultiplication.setOnClickListener { prepareOperation(Operation.multi) }
        buttonDiv.setOnClickListener { prepareOperation(Operation.div) }
        buttonResult.setOnClickListener {
         val result= doCurrentOperation()
            textNumber.text=result.toString()
        }

    }

    private fun doCurrentOperation():Double {
        val secondNumber=textNumber.text.toString().toDouble()
   return   when(currentOperation){
         Operation.plus ->lastNumber + secondNumber
         Operation.minus ->lastNumber - secondNumber
         Operation.multi ->lastNumber * secondNumber
         Operation.div ->lastNumber / secondNumber
         null ->0.0

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
    fun prepareOperation(operation:Operation){
        lastNumber=textNumber.text.toString().toDouble()
        clearInput()
        currentOperation=operation

    }
}