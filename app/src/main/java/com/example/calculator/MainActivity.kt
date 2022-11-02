package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var tvRes: TextView

    private var num1 = 0.0
    private var operation = ""

    private var text = ""
    private var number = ""
    private var point = "."
    private var counterOP = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRes = findViewById(R.id.tvRes)
    }

    fun numberClick (clickedView : View){
        if(clickedView is TextView){

            text = tvRes.text.toString()
            number = clickedView.text.toString()
            if(text == "0"){
                text = ""
            }
            if(text == "."){
                text = ""
                Toast.makeText(this, "არასწორი რიცხვი", Toast.LENGTH_SHORT ).show()
            }
            val res = text + number
            tvRes.text = res
        }
    }

    fun delClick(clickedView: View){
        if(clickedView is TextView){
            if(tvRes.text != ""){
               tvRes.text = tvRes.text.dropLast(1) // waushlis bolo 1 cifrs
            }
        }
    }

    fun clearClick(clickedView: View){
        if(clickedView is TextView){
            tvRes.text = ""
            operation = ""
            num1 = 0.0
            counterOP = 0
        }
    }

    fun pointClick(clickedView: View){
        if(clickedView is TextView){
            tvRes.text = text + number + point

            var counter = 0
            for (c in tvRes.text) {
                if (c == '.') {
                    counter++
                }
            }

            if(counter >= 2){
                Toast.makeText(this, "არასწორი რიცხვი", Toast.LENGTH_SHORT ).show()
                tvRes.text = ""
            }
        }
    }

    fun operationClick (clickedView: View){
        if(clickedView is TextView) {

            counterOP ++
            if(counterOP < 2) {
                num1 = tvRes.text.toString().toDouble()
            }
            else{
                counterOP = 1
            }

            operation = clickedView.text.toString()
            operation = operation.takeLast(1)

            tvRes.text = ""
        }
    }

    fun equalsClick (clickedView: View){
        if(clickedView is TextView){
            if(tvRes.text == ""){
                Toast.makeText(this, "არასწორი ჩანაწერი", Toast.LENGTH_SHORT ).show()
                clearClick(clickedView)
            }
            else{
                val num2 = tvRes.text.toString().toDouble() //tvRes.text aris meore ricxvi isev pirveli funqciidan
                when(operation) {
                    "+" -> tvRes.text = (num1 + num2).toString()
                    "-" -> tvRes.text = (num1 - num2).toString()
                    "*" -> tvRes.text = (num1 * num2).toString()
                    "/" -> tvRes.text = (num1 / num2).toString()
                }
            }
        }
    }
}
