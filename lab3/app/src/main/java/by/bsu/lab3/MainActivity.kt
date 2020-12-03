package by.bsu.lab3

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import by.bsu.lab3.service.ComputingService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var computingService: ComputingService
    private var serviceBound: Boolean = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as ComputingService.LocalBinder
            computingService = binder.getService()
            serviceBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            serviceBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        Intent(this, ComputingService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        serviceBound = false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val firstNumber: Double = first_number.text.toString().toDouble()
        val secondNumber: Double = second_number.text.toString().toDouble()

        return when (item.itemId) {
            R.id.plus -> {
                service_result.text = computingService.computeSum(firstNumber, secondNumber).toString()
                true
            }
            R.id.multiply -> {
                service_result.text = computingService.computeMultiplication(firstNumber, secondNumber).toString()
                true
            }
            R.id.divide -> {
                service_result.text = computingService.computeDivision(firstNumber, secondNumber).toString()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}