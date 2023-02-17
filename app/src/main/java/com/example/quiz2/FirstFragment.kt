package com.example.quiz2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class FirstFragment : Fragment() {

    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.user_name).text = arguments?.getString(Constants.USER_NAME)

        val lista = listOf(
            RecyclerElement(R.string.arte, R.string.difficile, "arte"),
            RecyclerElement(R.string.storia, R.string.facile, "storia"),
            RecyclerElement(R.string.musica, R.string.facile, "musica"),
            RecyclerElement(R.string.cinema, R.string.difficile, "cinema"),
            RecyclerElement(R.string.videogiochi, R.string.facile, "videogiochi"),
            RecyclerElement(R.string.serie_tv, R.string.difficile, "serie tv"),
            RecyclerElement(R.string.programmazione, R.string.facile, "programmazione"),
            RecyclerElement(R.string.inglese, R.string.facile, "inglese"),
            RecyclerElement(R.string.matematica, R.string.difficile, "matematica"),
        )


        layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(lista, onClick = {element ->
            if (element != null) { //when
                if (element.key == "arte"){
                    //getmusicquestion
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                } else {
                    Toast.makeText(requireActivity(), "Deve essere implementato", Toast.LENGTH_SHORT).show()
                }

                //if element.key == arte vai
            }
        })
        recyclerView.adapter = adapter
    }

}