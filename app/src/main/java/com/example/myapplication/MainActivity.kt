package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val stra = binding.editA.text.toString()
            val strb = binding.editB.text.toString()
            val strc = binding.editC.text.toString()
            val d = strb.toInt()*strb.toInt() - 4*stra.toInt()*strc.toInt()
            when {
                d < 0 -> binding.textView.text = "Нет действ. решений"
                d == 0 -> {
                    val x = - strb.toInt()/(2*stra.toInt())
                    binding.textView.text = "x = $x"
                }
                d > 0 -> {
                    val x1 = -strb.toInt() + sqrt(d.toFloat())/(2*stra.toInt())
                    val x2 = -strb.toInt() - sqrt(d.toFloat())/(2*stra.toInt())
                    binding.textView.text = "x1 = $x1, x2 = $x2"
                }
            }
        }
    }
}