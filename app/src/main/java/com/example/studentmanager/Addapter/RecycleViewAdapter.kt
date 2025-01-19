package com.example.studentmanager.Addapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanager.Model.Student
import com.example.studentmanager.R

class RecycleViewAdapter(private val studentList: MutableList<Student>?) :
    RecyclerView.Adapter<ViewHolder>() {
        var listier:onClickListier?=null
    override fun getItemCount(): Int = this.studentList?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val studentView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_of_list, parent, false)

        return ViewHolder(studentView,listier)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.studentList?.get(position), position)
    }
}