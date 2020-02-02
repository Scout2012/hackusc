package com.example.hackusc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var dropButton: Button
    lateinit var findButton: Button
    lateinit var name : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val beAngelBtn = findViewById<Button>(R.id.be_angel)
        val needAngelBtn= findViewById<Button>(R.id.need_angel)

        dropButton = findViewById<Button>(R.id.need_angel)
        findButton = findViewById<Button>(R.id.be_angel)
        //The question mark is part of safe calling.
        //calls method if object is not null, otherwise returns null
        //essentially, it is doing NPE handling for us :D

        //This is the implemented method call from the object
        needAngelBtn?.setOnClickListener {
            val intent = Intent(this, NearbyAngels::class.java)
            startActivity(intent)
        }
        beAngelBtn?.setOnClickListener {
            val intent = Intent(this, NewAngel::class.java)
            startActivity(intent)

            saveAngelDrop()
        }
    }

    private fun saveAngelDrop(){

        val ref = FirebaseDatabase.getInstance().getReference("Angel Drops")

        val angelDropId = ref.push().key as String

        val angelDrop = AngelDrops("test", 1)

        ref.child(angelDropId).setValue(angelDrop).addOnSuccessListener {
            Toast.makeText(applicationContext, "Drop Saved Succesfully", Toast.LENGTH_LONG)
                .show()
        }


    }

    private fun findAngelDrop(){



    }
}
