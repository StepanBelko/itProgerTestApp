package com.example.itprogertestapp

import android.content.DialogInterface
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.itprogertestapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        init()
    }

    private fun init() {
        binding.button.setOnClickListener {
            btnClick()
        }
        binding.button2.setOnClickListener {
            btn2Click()
        }
        binding.button3.setOnClickListener {
            btn3Click()
        }
        binding.nextActivityButton.setOnClickListener {
            toNextActivity()
        }
    }

    private fun btn3Click() {
        showInfo(binding.button.text.toString(), binding.button3)
    }

    private fun btn2Click() {
        showInfoAlert("Do you want to close app?")
    }

    private fun btnClick() {
        showInfo(binding.button.text.toString(), binding.button)
    }

    private fun showInfo(
        text: String?,
        btn: Button
    ) {
        btn.text = "Allready pushed"
        btn.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun showInfoAlert(text: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Important alert")
            .setMessage(text)
            .setCancelable(false)
            .setPositiveButton(
                "Of course",
                DialogInterface.OnClickListener { dialog, which -> onDestroy() })
            .setNegativeButton(
                "No",
                DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        val dialog = builder.create()
        dialog.show()
    }

    private fun toNextActivity() {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}