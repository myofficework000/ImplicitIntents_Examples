package com.example.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_login)
        val edtMobileNum = findViewById<EditText>(R.id.edt_mobile)
        val terms = findViewById<TextView>(R.id.txt_terms_and_conditons)

        button.setOnClickListener {
            doLogin(edtMobileNum.text.toString())
        }

        terms.setOnClickListener {
            openTermsAndConditions()
        }
    }

    private fun openTermsAndConditions() {
        //implicit intent... 
        // call
        // call logs
        //contacts
        // broswer -- done
        //gallary
        //Camera
        //show alarms

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://www.google.com")
        startActivity(intent)
    }

    private fun doLogin(mobileNumber: String) {
        //Explicit intent....
        Toast.makeText(this, "User logged in successfully", Toast.LENGTH_LONG).show()
        //move to next screen once login process is done...??????

        //here we are making an explicit intent....
        startActivity(Intent(this, HomeScreen::class.java))

        //startActivity -- method to call a activity
        //start service -- method to call a service

        //components of Application in android
        //. Activity   // Service // BroadCastReceiver // Content Provider

        //Types of Android Intents
        //Implicit intent -- browser, camera, contacts
        //Explicit intent -- activity
    }
}