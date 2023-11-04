package com.example.simplegmail2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
       // setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val emails = listOf(
            "Email 1",
            "Email 2",
            "Email 3",
            "Email 4",
            "Email 5"
        )

        val adapter = EmailAdapter(emails)
        recyclerView.adapter = adapter
    }
}
