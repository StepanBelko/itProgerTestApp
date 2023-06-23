package com.example.itprogertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.itprogertestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()

    }

    private fun init(){
        binding!!.addButton.setOnClickListener {
            count()
        }
        binding!!.nextActivityButton.setOnClickListener{
            toNextActivity()
        }
    }

    private fun count() {
        val num1 = Integer.parseInt(binding!!.numberField1.text.toString())
        val num2 = Integer.parseInt(binding!!.numberField2.text.toString())
        val res = num1 + num2
        binding!!.resultTextView.text = res.toString()
    }

    private fun toNextActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}