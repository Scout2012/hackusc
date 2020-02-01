package com.example.hackusc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var beAngelBtn = findViewById<Button>(R.id.be_angel)
        var needAngelBtn= findViewById<Button>(R.id.need_angel)

        //The question mark is part of safe calling.
        //calls method if object is not null, otherwise returns null
        //essentially, it is doing NPE handling for us :D

        //This is the implemented method call from the object
        needAngelBtn?.setOnClickListener {
            val intent = Intent(this, NearbyAngels::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity, R.string.app_name, Toast.LENGTH_LONG).show()
        }
    }
}
