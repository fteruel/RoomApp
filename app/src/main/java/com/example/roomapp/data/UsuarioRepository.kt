package com.example.roomapp.data

import androidx.lifecycle.LiveData

class UsuarioRepository(private val userDao: UserDao) {
    //Uso una lista de Usuarios adentro de LiveData
    val readAllData: LiveData<List<Usuario>> = userDao.readAllData()

    suspend fun agregarUsuario(usuario: Usuario){
        userDao.agregarUsuario(usuario)
    }

}