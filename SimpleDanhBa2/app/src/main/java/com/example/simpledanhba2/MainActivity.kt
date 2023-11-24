package com.example.simpledanhba2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.simpledanhba2.Contact
import com.example.simpledanhba2.ContactDetailFragment
import com.example.simpledanhba2.ContactListFragment
import com.example.simpledanhba2.R


class MainActivity : AppCompatActivity(), ContactListFragment.OnContactSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showContactListFragment()
        }
    }

    private fun showContactListFragment() {
        replaceFragment(ContactListFragment.newInstance(), "ContactListFragment")
    }

    override fun onContactSelected(contact: Contact) {
        showContactDetailFragment(contact)
    }

    private fun showContactDetailFragment(contact: Contact) {
        replaceFragment(ContactDetailFragment.newInstance(contact), "ContactDetailFragment")
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}
