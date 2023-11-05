package com.example.oopdemo

import android.util.Log

class MyCar : Car(), SpeedController {
    override fun start() {
        Log.i("MYTAG","this is Mycar starting... BrandId id ${getBrandID()}")
    }

    override fun accelaration() {
        TODO("Not yet implemented")
    }

    override fun deaccelaration() {
        TODO("Not yet implemented")
    }
}