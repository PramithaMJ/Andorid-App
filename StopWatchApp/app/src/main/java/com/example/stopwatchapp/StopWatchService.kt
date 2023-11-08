package com.example.stopwatchapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.flow.combine
import java.util.Timer
import java.util.TimerTask

class StopWatchService : Service() {
    override fun onBind(p0: Intent?): IBinder? = null
    private val timer = Timer()
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val time = intent.getDoubleExtra(CURRENT_TIME,0.0)
        timer.scheduleAtFixedRate(StopWatchTimeTask(time),0,1000)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }
    companion object{
        const val CURRENT_TIME = "current time"
        const val UPDATED_TIME = "updated"
    }

    private inner class StopWatchTimeTask(private var time:Double):TimerTask() {
        override fun run() {
            val intent = Intent(UPDATED_TIME)
            time ++
            intent.putExtra(CURRENT_TIME,time)
            sendBroadcast(intent)
        }
    }

}