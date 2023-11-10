package com.example.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel(){
    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
        get() = total

    init {
        total.value = startingTotal
    }

    // don't need this function because live data will automatically observed data
//    fun getTotal():Int{
//        return total
//    }

    fun setTotal(input:Int){
        //total +=input // without using liveData
        total.value = (total.value)?.plus(input) // when using liveData
    }
}