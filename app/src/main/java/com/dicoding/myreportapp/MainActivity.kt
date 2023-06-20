package com.dicoding.myreportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("Test debugging")

        val btnCrash = findViewById<Button>(R.id.btn_crash)
        btnCrash.setOnClickListener {
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            FirebaseCrashlytics.getInstance().setCustomKey("str_key", "some_data")
            try {
                throw RuntimeException("Test Crash")
            } catch (e: Exception) {
                Timber.e("Test non fatal exception")
            }
        }
    }
}