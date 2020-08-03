package com.example.roomapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapp.R
import com.example.roomapp.data.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mUserViewModel : UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflo a el tamaño completo del fragment


        val view = inflater.inflate(R.layout.fragment_list, container, false)


        //RecylerView

        val adapter = ListAdapter()
        val recyclerView = view.listaRV
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UserViewModel

        mUserViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { usuario -> adapter.setData(usuario) })


        //llamo al FAB y hago que el NavController llama al fragmento ADD
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment) }


        return view
    }
 }