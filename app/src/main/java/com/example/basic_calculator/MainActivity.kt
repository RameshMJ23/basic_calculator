package com.example.basic_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCalculate.setOnClickListener {

            val firstNum = etFirstNum.text.toString().toDouble()

            val secondNum = etSecondNum.text.toString().toDouble()

            val selectedOperation =
                findViewById<RadioButton>(rgOperations.checkedRadioButtonId).text.toString()

            val finalResult = when (selectedOperation) {
                "Add" -> firstNum + secondNum
                "Subtract" -> firstNum - secondNum
                "Multiply" -> firstNum * secondNum
                "Divide" -> firstNum / secondNum
                else -> 0.0
            }

            tvFinalValue.text = if (cbApprox.isChecked) {
                    finalResult.roundToInt().toString()
                } else {
                    finalResult.toString()
                }
        }
    }
}