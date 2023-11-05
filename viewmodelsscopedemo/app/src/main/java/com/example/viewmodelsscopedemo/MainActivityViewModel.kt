package com.example.viewmodelsscopedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
//    private val myJob = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + myJob)

    fun getUserData(){
        viewModelScope.launch {
            //write some code
        }
    }
//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }

}