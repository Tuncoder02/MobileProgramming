package com.example.simpledanhba2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class ContactListFragment : Fragment() {

    interface OnContactSelectedListener {
        fun onContactSelected(contact: Contact)
    }

    private var listener: OnContactSelectedListener? = null
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadContacts()
    }

    private fun setupRecyclerView() {
        contactAdapter = ContactAdapter { contact ->
            listener?.onContactSelected(contact)
        }

        recyclerContactList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contactAdapter
        }
    }

    private fun loadContacts() {
        val contactList = getDummyContactList()
        contactAdapter.submitList(contactList)
    }

    private fun getDummyContactList(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(Contact("John Doe", "123456789"))
        contacts.add(Contact("Jane Doe", "987654321"))
        return contacts
    }

    companion object {
        fun newInstance() = ContactListFragment()
    }
}
