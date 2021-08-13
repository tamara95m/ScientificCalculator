package com.tamara.scientificcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tamara.scientificcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    var lastNumber:Double=0.0
    var currentOperation:Operations?=null
    var cp:ScOperations?=null
    var lastResult:Double =0.0
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       addCallBack()

    }

     fun addCallBack() {
      this.binding.buttonClear.setOnClickListener {
            clearInput()
        }
     this.binding.buttonPlus.setOnClickListener { prepareOperation(Operations.plus) }
       this.binding.buttonMinus.setOnClickListener { prepareOperation(Operations.minus) }
      this.  binding.buttonMulti.setOnClickListener { prepareOperation(Operations.multi) }
       this. binding.buttonDiv.setOnClickListener { prepareOperation(Operations.div) }
      this.  binding.buttonSin.setOnClickListener { pp(ScOperations.sine) }
      this.  binding.buttonCos.setOnClickListener { pp(ScOperations.cosin) }
       this. binding.buttonTan.setOnClickListener { pp(ScOperations.tan) }
      this. binding.buttonResult.setOnClickListener {
         val result= doCurrentOperation()
           binding.textNumber.text=result.toString()
        }

    }

    private fun doCurrentOperation():Double {
        val secondNumber=binding.textNumber.text.toString().toDouble()

        if(currentOperation != null){
  lastResult=   when(currentOperation ){
         Op.Plus ->lastNumber + secondNumber
         Op.Minus ->lastNumber - secondNumber
         Op.Multi ->lastNumber * secondNumber
         Op.Div ->lastNumber / secondNumber

      null -> 0.0

  }}
        else if(cp != null)
        {
            lastResult=   when(cp ) {
               ScOperations.sine -> Math.sin(Math.toRadians(secondNumber))
                ScOperations.cosin ->Math.cos(Math.toRadians(secondNumber))
                ScOperations.tan ->Math.tan(Math.toRadians(secondNumber))
                null ->0.0
            }
            binding.button10.text=this.getString(R.string.app_name)
        }
        return lastResult
    }



    fun onClickNumber(v: View)
    {val newDigit=(v as Button).text.toString()
        val oldDigit=binding.textNumber.text.toString()
        val newTextNumber=oldDigit+newDigit
       binding.textNumber.text=newTextNumber


    }
    fun clearInput(){
       binding.textNumber.text=""


    }
    fun prepareOperation(operation:Operations){
        lastNumber=binding.textNumber.text.toString().toDouble()
        clearInput()
        currentOperation=operation

    }
    fun pp(scientificOperations: ScOperations)
    {
        cp=scientificOperations

    }

}