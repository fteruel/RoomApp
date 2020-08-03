package com.example.roomapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R
import com.example.roomapp.data.Usuario
import com.example.roomapp.data.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [addFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class addFragment : Fragment() {

    private lateinit var UserViewModel: UsuarioViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.button.setOnClickListener {

            insertarDataABaseDeDatos()
        }



        return view
    }

    private fun insertarDataABaseDeDatos() {

        val nombre = nombreTV.text.toString()
        val apellido = apellidoTV.text.toString()
        val edad = edadTV.text

        if (!(TextUtils.isEmpty(nombre) && TextUtils.isEmpty(apellido) && edad.isEmpty())){

            val usuario = Usuario(0, nombre, apellido, Integer.parseInt(edad.toString()))

            UserViewModel.addUser(usuario)

            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }

    }

}