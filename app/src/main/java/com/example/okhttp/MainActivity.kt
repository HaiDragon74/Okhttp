package com.example.okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = ApiService()
        val ok=OkHttpClient()

        GlobalScope.launch(Dispatchers.IO) {
            val result = client.run(ok)
            if (result != null) {
                Log.d("dasdadada",result.toString())
            } else {
                Log.d("dasdadada",result.toString())
            }
        }
    }
}