package com.example.studentregisterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.studentregisterapp.db.Student
import com.example.studentregisterapp.db.StudentDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText :EditText
    private lateinit var emailEditText :EditText
    private lateinit var saveButton :Button
    private lateinit var clearButton :Button

    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.etName)
        emailEditText = findViewById(R.id.etEmail)
        saveButton = findViewById(R.id.btnSave)
        clearButton = findViewById(R.id.btnClear)

        val dao = StudentDatabase.getInstance(application).studentDao()
        val factory = StudentVewModelFactory(dao)
        viewModel = ViewModelProvider(this,factory).get(StudentViewModel::class.java)

        saveButton.setOnClickListener{
            saveStudentData()
            clearInput()
        }
        clearButton.setOnClickListener {
            clearInput()
        }
    }

    private fun saveStudentData(){
//        val name = nameEditText.text.toString()
//        val email = emailEditText.text.toString()
//        val student = Student(0,name,email)
//        viewModel.insertStudent(student)

        viewModel.insertStudent(
            Student(
                0,
                nameEditText.text.toString(),
                emailEditText.text.toString()
            )
        )
    }
    private fun clearInput(){
        nameEditText.setText("")
        emailEditText.setText("")

    }
}