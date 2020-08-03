package com.example.roomapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
//creo macro para la entidad
@Entity(tableName = "user_table")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val apellido: String,
    val edad: Int
)