package com.example.myapplication

import android.widget.TextView

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.btn_0).setOnClickListener { setTextFields("0") }
        findViewById<TextView>(R.id.btn_1).setOnClickListener { setTextFields("1") }
        findViewById<TextView>(R.id.btn_2).setOnClickListener { setTextFields("2") }
        findViewById<TextView>(R.id.btn_3).setOnClickListener { setTextFields("3") }
        findViewById<TextView>(R.id.btn_4).setOnClickListener { setTextFields("4") }
        findViewById<TextView>(R.id.btn_5).setOnClickListener { setTextFields("5") }
        findViewById<TextView>(R.id.btn_6).setOnClickListener { setTextFields("6") }
        findViewById<TextView>(R.id.btn_7).setOnClickListener { setTextFields("7") }
        findViewById<TextView>(R.id.btn_8).setOnClickListener { setTextFields("8") }
        findViewById<TextView>(R.id.btn_9).setOnClickListener { setTextFields("9") }

        findViewById<TextView>(R.id.btn_star).setOnClickListener { setTextFields("*") }
        findViewById<TextView>(R.id.bnt_slash).setOnClickListener { setTextFields("/") }
        findViewById<TextView>(R.id.btn_plus).setOnClickListener { setTextFields("+") }
        findViewById<TextView>(R.id.btn_minus).setOnClickListener { setTextFields("-") }
        findViewById<TextView>(R.id.bnt_bracket1).setOnClickListener { setTextFields("(") }
        findViewById<TextView>(R.id.bnt_bracket2).setOnClickListener { setTextFields(")") }

        findViewById<TextView>(R.id.bnt_AC).setOnClickListener {
            findViewById<TextView>(R.id.math_operation).text = ""
            findViewById<TextView>(R.id.result_text).text = ""
        }

        findViewById<TextView>(R.id.btn_back).setOnClickListener {
            val str = findViewById<TextView>(R.id.math_operation).text.toString()
            if (str.isNotEmpty())
                findViewById<TextView>(R.id.math_operation).text = str.substring(0, str.length - 1)
            findViewById<TextView>(R.id.result_text).text = ""
        }

        findViewById<TextView>(R.id.btn_evenly).setOnClickListener {
            //Блок для отслеживания ошибок
            val ex = ExpressionBuilder(findViewById<TextView>(R.id.math_operation).text.toString()).build()
            val result = ex.evaluate()
            findViewById<TextView>(R.id.result_text).text = result.toString()
        }

    }

    fun setTextFields(str : String) {
        findViewById<TextView>(R.id.math_operation).append(str)
    }
}