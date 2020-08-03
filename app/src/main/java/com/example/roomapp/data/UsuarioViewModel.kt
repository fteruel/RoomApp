package com.example.roomapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Usuario>>
    private val repository: UsuarioRepository

    init {
        val userDao = usuarioDataBase.getDatabase(application).userDao()
        repository = UsuarioRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.agregarUsuario(usuario)
        }
    }

}