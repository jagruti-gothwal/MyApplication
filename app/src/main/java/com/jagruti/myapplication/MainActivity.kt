package com.jagruti.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.jagruti.myapplication.model.JsonResponse

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        getUserDetails()
    }

    private fun getUserDetails() {
        AndroidNetworking.get("https://randomuser.me/api/?results=100&inc=login,name,email,gender,location,phone,picture&noinfo")
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(JsonResponse::class.java,object : ParsedRequestListener<JsonResponse> {
                override fun onResponse(response: JsonResponse?) {
                    setupRecyclerView(response)
                }

                override fun onError(anError: ANError?) {
                    Log.d("MainActivity",anError?.localizedMessage)
                }
            })
    }

    private fun setupRecyclerView(response: JsonResponse?) {
        val myAdapter = response?.results?.let{MyAdapter(it)}
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation=RecyclerView.VERTICAL
        recyclerView.layoutManager=linearLayoutManager
        recyclerView.adapter=myAdapter
    }

    private fun bindViews() {
        recyclerView=findViewById(R.id.recyclerView)
    }
}