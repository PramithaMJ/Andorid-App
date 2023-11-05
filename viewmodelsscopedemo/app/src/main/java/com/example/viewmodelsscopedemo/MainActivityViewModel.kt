package com.example.viewmodelsscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelsscopedemo.model.User
import com.example.viewmodelsscopedemo.model.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
//    private val myJob = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + myJob)

    private var userRepository = UserRepository()
        var users : MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }
            users.value = result
            //write some code
        }
    }
//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }

}