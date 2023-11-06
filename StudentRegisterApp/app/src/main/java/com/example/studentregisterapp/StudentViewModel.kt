package com.example.studentregisterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentregisterapp.db.Student
import com.example.studentregisterapp.db.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val dao: StudentDao): ViewModel() {

    val students = dao.getAllStudent()

    fun insertStudent(student: Student)=viewModelScope.launch {
        dao.insertStudent(student)
    }
    fun updateStudent(student: Student)=viewModelScope.launch {
        dao.insertStudent(student)
    }
    fun deleteStudent(student: Student)=viewModelScope.launch {
        dao.insertStudent(student)
    }
}