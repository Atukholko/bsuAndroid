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
        
        val intent = intent
        value.text = intent.getStringExtra("valueFirstActivity")
        val firstVal = if(value.text.isNotEmpty()) value.text.toString().toInt() else 0

        ok_button.setOnClickListener {
            val secondVal = if(enter_value.text.isNotEmpty()) enter_value.text.toString().toInt() else 0
            val sum = firstVal + secondVal
            val returnIntent = Intent().apply {
                putExtra("result", sum.toString())
            }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}