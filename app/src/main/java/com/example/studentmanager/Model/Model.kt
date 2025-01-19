package com.example.studentmanager.Model

class Model private constructor() {
    companion object {
        val instance: Model = Model()
    }

    val students: MutableList<Student> = ArrayList()

    init {
        students.add(Student("Ali", 1235, 552487790, "Bnei Brak", false))
    }

    //TODO  ask yehuda what is companion object
    //TODO  1. fun add for new student
    //TODO  2. fun set for edit
    //TODO  3. fun get for show details
    //TODO  4. fun remove for delete student from list

    fun addStudent(newStudent: Student) {
        this.students.add(newStudent)
    }

    fun getStudent(i: Int): Student {
        return this.students[i]
    }

    fun editStudent(i: Int, newStudent: Student) {
        this.students.removeAt(i)
        this.students.add(i, newStudent)
    }

    fun removeStudent(i: Int) {
        this.students.removeAt(i)
    }
}