package com.example.studentmanager

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentmanager.Model.Student

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val student=intent.getSerializableExtra("student")as? Student

        val name=findViewById<TextView>(R.id.detals_name)
        val id=findViewById<TextView>(R.id.detals_id)
        val phone =findViewById<TextView>(R.id.detals_phone)
        val address=findViewById<TextView>(R.id.detals_address)

        name.text=student?.name
        id.text=student?.id.toString()
        phone.text=student?.phone.toString()
        address.text=student?.address
    }

}