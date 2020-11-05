package by.bsu.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.form.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form)

        val receivedIntent = intent
        value.text = receivedIntent.getStringExtra("valueFirstActivity")
        val valFirstActivity = if(value.text.isNotEmpty()) value.text.toString().toInt() else 0

        ok_button.setOnClickListener {
            val valSecondActivity = if(enter_value.text.isNotEmpty()) enter_value.text.toString().toInt() else 0
            val result = valFirstActivity + valSecondActivity
            val returnIntent = Intent().apply {
                putExtra("result", result.toString())
            }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}