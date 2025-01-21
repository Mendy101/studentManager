package com.example.studentmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    var i:Int=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val i=intent.getIntExtra("position",-1)
        if(i!=-1){
       presentStudent(i)
        }else return

        findViewById<Button>(R.id.details_edit_btn).setOnClickListener{
            val intent=Intent(this, EditActivity::class.java)
            intent.putExtra("position",i)
            startActivity(intent)
        }
    }



    @SuppressLint("SetTextI18n")
    fun presentStudent(i:Int){
        val  student = Model.instance.getStudent(i)
        val name=findViewById<TextView>(R.id.detals_name)
        val id=findViewById<TextView>(R.id.detals_id)
        val phone =findViewById<TextView>(R.id.detals_phone)
        val address=findViewById<TextView>(R.id.detals_address)
        val checkBox=findViewById<CheckBox>(R.id.details_checkBox)


        name.text = "Name: ${student.name}"
        id.text = "ID: ${student.id.toString()}"
        phone.text = "Phone: ${student.phone.toString()}"
        address.text = "Address: ${student.address}"
       checkBox.isChecked = student.isChecked ?: false

    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        val i=intent.getIntExtra("position",-1)
        if(i!=-1){
            presentStudent(i)
        }else return

    }
}