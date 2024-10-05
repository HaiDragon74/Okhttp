package com.example.okhttp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import kotlin.jvm.Throws

class ApiService {
    @Throws(IOException::class)
    fun run(client: OkHttpClient): List<User> {
        val request = Request.Builder()
            .url("https://api.github.com/users")
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val responseBodyString = response.body?.string() ?: ""
            return Gson().fromJson(responseBodyString, object : TypeToken<List<User>>() {}.type)
        }
    }
}