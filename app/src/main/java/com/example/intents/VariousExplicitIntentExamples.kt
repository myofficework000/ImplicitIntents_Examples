package com.example.intents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.PatternMatcher
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class VariousExplicitIntentExamples : AppCompatActivity() {

    val CALL_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_various_explicit_intent_examples)
        setUpPermissions()
        initViews()
    }

    private fun initViews() {
        val callButton = findViewById<Button>(R.id.button_call)
        val callLogButton = findViewById<Button>(R.id.button_call_log)
        val contactsButton = findViewById<Button>(R.id.button_contacts)
        val galleryButton = findViewById<Button>(R.id.button_gallery)
        val browserButton = findViewById<Button>(R.id.button_browser)
        val cameraButton = findViewById<Button>(R.id.button_camera)
        val alarmButton = findViewById<Button>(R.id.button_alarm)

        callButton.setOnClickListener { callButton() }
        callLogButton.setOnClickListener { callLogButton() }
        contactsButton.setOnClickListener { contactsButton() }
        galleryButton.setOnClickListener { galleryButton() }
        browserButton.setOnClickListener { browserButton() }
        cameraButton.setOnClickListener { cameraButton() }
        alarmButton.setOnClickListener { alarmButton() }

    }

    private fun callButton() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("+91 9599652867")
        startActivity(intent)
    }

    private fun callLogButton() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.type = CallLog.Calls.CONTENT_TYPE   // discuss later when we work on content provider
        startActivity(intent)
    }

    private fun contactsButton() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = ContactsContract.Contacts.CONTENT_TYPE
        startActivity(intent)
    }

    private fun galleryButton() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("content://media/external/images/media/")
        startActivity(intent)
    }

    private fun browserButton() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://www.google.com")
        startActivity(intent)
    }

    private fun cameraButton() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }

    private fun alarmButton() {
        val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
        startActivity(intent)
    }

    private fun setUpPermissions() {
        val permission =
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.CALL_PHONE),
            CALL_REQUEST_CODE
        )
    }


}