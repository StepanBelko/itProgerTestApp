package com.example.itprogertestapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.itprogertestapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_third)

        setNewFragment(FirstFragment())
        init()

    }

    private fun init() {
        binding.btnFragment1.setOnClickListener {
            Toast.makeText(this,"FIRST FRAGMENT", Toast.LENGTH_SHORT).show()
            setNewFragment(FirstFragment())
        }
        binding.btnFragment2.setOnClickListener {
            Toast.makeText(this,"Second FRAGMENT", Toast.LENGTH_SHORT).show()
            setNewFragment(SecondFragment())
        }
        binding.nextActivitybtn.setOnClickListener {
            toNextActivity()
        }
        binding.prewActivitybtn.setOnClickListener {
            toPrewActivity()
        }
    }

    private fun setNewFragment(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
    private fun toNextActivity() {

    }

    private fun toPrewActivity(){

    }
}