package by.bsu.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.form.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form)
        val reqCode = 10;
        ok_button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("valueFirstActivity", enter_value.text.toString())
            startActivityForResult(intent, reqCode)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("result")
                value.text = result
            }
        }
    }
}