package com.example.oopdemo

import android.util.Log

class Driver(var name : String, credit : Int) { // Primary constructor
    // var driverName = ""  // Field Variable
    // lateinit var driverName :String
   // var driverName =name
    private var totalCredit = 50
    private var car = Car()

    init {
      //  driverName = name
        totalCredit += 50
        car.maxSpeed =150
        car.start()
    }

    fun showDetails(){
        Log.i("MYTAG", "Name of the driver is $name with $totalCredit")
    }
}