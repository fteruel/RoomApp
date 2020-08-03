package com.example.roomapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.data.Usuario
import kotlinx.android.synthetic.main.fila.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private  var listaUsuarios = emptyList<Usuario>()

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fila, parent, false))
    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemActual = listaUsuarios[position]
        holder.itemView.idTV.text = itemActual.id.toString()
        holder.itemView.nombreTV.text = itemActual.nombre.toString()
        holder.itemView.apellidoTV.text = itemActual.apellido.toString()
        holder.itemView.edadTV.text = itemActual.edad.toString()
    }

    fun setData(usuarios : List<Usuario>){
        this.listaUsuarios = usuarios
        notifyDataSetChanged()


    }
}