package by.bsu.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.form.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form)

        ok_button.setOnClickListener {
            val valueTextView = value.text.toString().toInt()
            val enteredValue = if(enter_value.text.isNotEmpty()) enter_value.text.toString().toInt() else 0
            val result = valueTextView + enteredValue
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("valueFirstActivity", result.toString())
            }
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("result")
                value.text = result
            }
        }
    }
}