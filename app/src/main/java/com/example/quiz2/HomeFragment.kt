package com.example.quiz2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_start).setOnClickListener {

            if (view.findViewById<EditText>(R.id.et_name).text.toString().isEmpty()) {
                Toast.makeText(context, "Inserisci il tuo nome per continuare", Toast.LENGTH_SHORT)
                    .show()
            } else {
                findNavController().navigate(R.id.action_homeFragment_to_firstFragment,
                    bundleOf(Constants.USER_NAME to view.findViewById<EditText>(R.id.et_name).text.toString()))

            }

        }
    }
}