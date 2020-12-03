package by.bsu.lab3.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class ComputingService : Service(){
    private val binder = LocalBinder()

    fun computeSum(numberOne: Double, numberTwo: Double): Double {
        return numberOne + numberTwo
    }

    fun computeMultiplication(numberOne: Double, numberTwo: Double): Double {
        return numberOne * numberTwo
    }

    fun computeDivision(numberOne: Double, numberTwo: Double): Double {
        return numberOne / numberTwo
    }

    inner class LocalBinder : Binder() {
        fun getService(): ComputingService = this@ComputingService
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

}