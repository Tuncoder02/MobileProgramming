
package com.example.simplegmail
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailListView: ListView = findViewById(R.id.emailListView)

        val emails = listOf(
            EmailAdapter.Email("John Doe", "Hello World", "10:00 AM"),
            EmailAdapter.Email("Alice Smith", "Meeting Invitation", "11:30 AM"),
            EmailAdapter.Email("Bob Johnson", "Project Update", "1:45 PM")
            // Thêm các email giả mạo khác ở đây
        )

        val adapter = EmailAdapter(this, emails)
        emailListView.adapter = adapter
    }

}

class EmailAdapter(private val context: Context, private val emails: List<Email>) : BaseAdapter() {

    data class Email(val sender: String, val subject: String, val time: String)

    override fun getCount(): Int {
        return emails.size
    }

    override fun getItem(position: Int): Any {
        return emails[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val emailView: View
        if (convertView == null) {
            emailView = LayoutInflater.from(context).inflate(R.layout.email_item, parent, false)
        } else {
            emailView = convertView
        }

        val senderTextView: TextView = emailView.findViewById(R.id.emailSender)
        val subjectTextView: TextView = emailView.findViewById(R.id.emailSubject)
        val timeTextView: TextView = emailView.findViewById(R.id.emailTime)

        val email = emails[position]

        senderTextView.text = email.sender
        subjectTextView.text = email.subject
        timeTextView.text = email.time

        return emailView
    }}
