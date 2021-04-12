package org.codejudge.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.txtNumber1)
        val editText2 = findViewById<EditText>(R.id.txtNumber2)
        val addButton = findViewById<Button>(R.id.btnAdd);
        val txtResult = findViewById<TextView>(R.id.txtResult)
        ConfigHelper.getConfigValue(this, "api_url")?.let { Log.i("API URL : ", it) };
        // finding the edit text

        // Setting On Click Listener
        addButton.setOnClickListener {

            // Getting the user input
            val txtNumber1 : String = editText1.text.toString()
            val txtNumber2 : String = editText2.text.toString()

            if (txtNumber1 == null || txtNumber2 == null || txtNumber1.equals("") || txtNumber2.equals("")) {
                txtResult.text = "NaN"
            }
            else {
                var number1: Double = editText1.text.toString().toDouble()
                var number2: Double = editText2.text.toString().toDouble()
                var sum : Double = number1 + number2;
                txtResult.text = sum.toString()
            }
        }
    }
}