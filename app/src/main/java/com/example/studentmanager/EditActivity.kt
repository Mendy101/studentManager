package com.example.studentmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class EditActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var id: EditText
    lateinit var phone: EditText
    lateinit  var address: EditText
    lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        init()
        val i = intent.getIntExtra("position", -1)
        if (i != -1) {
            presentStudent(i)
            allClicks(i)
        } else return
    }



    private fun init(){
        name = findViewById(R.id.edit_name)
        id = findViewById(R.id.edit_id)
        phone = findViewById(R.id.edit_phone)
        address = findViewById(R.id.edit_addres)
        checkBox = findViewById(R.id.edit_checkBox)
    }
    private fun presentStudent(i:Int) {
        val student=Model.instance.getStudent(i)

        name?.setText(student.name)
        id?.setText(student.id.toString())
        phone?.setText(student.phone.toString())
        address?.setText(student.address)
        checkBox.isChecked=student.isChecked

    }
    private fun allClicks(i: Int) {
        findViewById<Button>(R.id.Edit_saveBtn).setOnClickListener { update(i) }
        findViewById<Button>(R.id.Edit_deleteBtn).setOnClickListener { remove(i) }
        findViewById<Button>(R.id.Edit_cancelBtn).setOnClickListener { finish() }
    }

    fun remove(i: Int) {
        Model.instance.removeStudent(i)
        val intent = Intent(this, MainActivity::class.java) // MainActivity היא Activity A
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun update(i: Int) {
        if (name.text.isEmpty() || id.text.isEmpty() || phone.text.isEmpty() ) {
            name.error="This field is required"
            id.error="This field is required"
            phone.error="This field is required"
            return
        }
        val student=Student(
            name.text.toString(),
                    id.text.toString().toInt(),
                    phone.text.toString().toInt(),
                    address.text.toString(),
                    checkBox.isChecked
        )
        Model.instance.editStudent(i,student)
        finish()
    }
}
