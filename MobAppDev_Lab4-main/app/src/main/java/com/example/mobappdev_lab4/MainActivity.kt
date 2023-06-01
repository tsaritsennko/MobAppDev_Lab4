package com.example.mobappdev_lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_DATE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, Activity2::class.java)
            val name = findViewById<EditText>(R.id.editText).text.toString()
            intent.putExtra("name", name)
            startActivity(intent)
            startActivityForResult(intent, REQUEST_DATE)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_DATE && resultCode == Activity.RESULT_OK) {
            val dateInMillis = data?.getLongExtra("date", 0) ?: 0
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = dateInMillis

            val textView = findViewById<TextView>(R.id.textView)
            textView.text = SimpleDateFormat("dd.MM.yyyy").format(calendar.time)
        }
    }
}