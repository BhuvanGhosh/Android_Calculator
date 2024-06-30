package com.example.calculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.GestureDetector
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    private var i: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val first = findViewById<EditText>(R.id.textFirst)
        val second = findViewById<EditText>(R.id.textsecond)
        val textview = findViewById<TextView>(R.id.textview)
        val add = findViewById<Button>(R.id.btnadd)
        val sub = findViewById<Button>(R.id.btnsub)
        val multi = findViewById<Button>(R.id.btnmul)
        val clean = findViewById<Button>(R.id.btnclean)
        val div = findViewById<Button>(R.id.btndiv)

        add.setOnClickListener{
            i++;
            val hand = Handler()

            hand.postDelayed({
                if(i==1){
                    val messfirst = first.text.toString().toInt()
                    val messSecond = second.text.toString().toInt()
                    val sum = messfirst + messSecond
                    textview.text = "Sum: $sum"
                }else if(i==2){
                    first.text.clear()
                    second.text.clear()
                    textview.text = ""
                    showPopUpMessage(this,"ADD","You have clicked Add which means you want to add soul mate numbers just like we added Together")
                }
                i =0
            }, 500)
        }

        sub.setOnClickListener{
            i++;
            val hand = Handler()

            hand.postDelayed({
                if(i==1){
                    val messfirst = first.text.toString().toInt()
                    val messSecond = second.text.toString().toInt()
                    var subtract = 0
                    if(messfirst > messSecond){
                        subtract =  messfirst - messSecond
                        textview.text = "Subtraction: $subtract"
                    }else{
                        subtract = messSecond - messfirst
                        textview.text = "Subtraction: -$subtract"
                    }
                }else if(i==2){
                    first.text.clear()
                    second.text.clear()
                    textview.text = ""
                    showPopUpMessage(this,"SUBTRACT","You have clicked Subtract which means you want to Delete the Numbers Just like we Delete the Negeative and Bad People in our Life")
                }
                i =0
            }, 500)
        }

        multi.setOnClickListener{
            i++;
            val hand = Handler()

            hand.postDelayed({
                if(i==1){
                    val messfirst = first.text.toString().toInt()
                    val messSecond = second.text.toString().toInt()
                    val multiple = messfirst * messSecond
                    textview.text = "Multiplication: $multiple"
                }else if(i==2){
                    first.text.clear()
                    second.text.clear()
                    textview.text = ""
                    showPopUpMessage(this,"MULTIPLE","You have clicked Multiple which means you want to Multiply the  numbers Just like our Happiness when we See our Love ones and Friends")
                }
                i =0
            }, 500)
        }

        div.setOnClickListener{
            i++;
            val hand = Handler()

            hand.postDelayed({
                if(i==1){
                    val messfirst = first.text.toString().toDouble()
                    val messSecond = second.text.toString().toDouble()
                    var divide = 0
                    if(messfirst>messSecond)
                    {
                        divide = (messfirst/messSecond).toInt()
                        textview.text = "Divide: $divide"
                    }else{
                        textview.text="We cant do divide.."
                    }
                }else if(i==2){
                    first.text.clear()
                    second.text.clear()
                    textview.text = ""
                    showPopUpMessage(this,"DIVIDE","You have clicked Divide which means you want to Divide  numbers just like our Money Got when we hangout Outside")
                }
                i =0
            }, 500)
        }
        clean.setOnClickListener{
            textview.text = ""
            first.text.clear()
            second.text.clear()
        }
    }
    private fun showPopUpMessage(context: Context,title: String,message: String){
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Ok"){_, _ ->}
       // builder.setNegativeButton("Cancle"){_, _ ->}
        val dialog = builder.create()
        dialog.show()
    }
}


