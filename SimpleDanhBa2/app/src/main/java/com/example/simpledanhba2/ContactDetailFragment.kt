package com.example.simpledanhba2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ContactDetailFragment : Fragment() {

    companion object {
        private const val ARG_CONTACT = "contact"

        fun newInstance(contact: Contact): ContactDetailFragment {
            val fragment = ContactDetailFragment()
            val args = Bundle()
            args.putSerializable(ARG_CONTACT, contact)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayContactDetails()
    }

    private fun displayContactDetails() {
        val contact = arguments?.getSerializable(ARG_CONTACT) as? Contact
        contact?.let {
            textContactName.text = it.name
            textContactNumber.text = it.number
        }
    }
}
