package com.example.studentmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanager.Addapter.RecycleViewAdapter
import com.example.studentmanager.Addapter.onClickListier
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class MainActivity : AppCompatActivity() {
    private var students: MutableList<Student>? = null
    private var adapter: RecycleViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.silver)

        onCreateRecycleView()
        allClicks()
    }

    private fun allClicks() {
        findViewById<Button>(R.id.Main_addBtn).setOnClickListener {
            val intent = Intent(this, AddStudent::class.java)
            startActivity(intent)
        }

        val intent = Intent(this, DetailsActivity::class.java)
        adapter?.listier = object : onClickListier {
            override fun onItemClick(position: Int) {
                intent.putExtra("position",position)
                startActivity(intent)
            }

        }

    }

    private fun onCreateRecycleView() {
        students = Model.instance.students
        val recycleView: RecyclerView = findViewById(R.id.Main_list)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = RecycleViewAdapter(students)
        recycleView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()

    }


}