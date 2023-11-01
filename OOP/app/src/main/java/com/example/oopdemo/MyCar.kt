package com.example.oopdemo

import android.util.Log

class MyCar : Car() {
    override fun start() {
        Log.i("MYTAG","this is Mycar start...")
    }
}