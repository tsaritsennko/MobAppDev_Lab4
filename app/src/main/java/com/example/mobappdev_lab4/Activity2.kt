package com.example.mobappdev_lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val name = intent.getStringExtra("name")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Привет, $name!"
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.set(datePicker.year, datePicker.month, datePicker.dayOfMonth)
            val intent = Intent()
            intent.putExtra("date", calendar.timeInMillis)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}