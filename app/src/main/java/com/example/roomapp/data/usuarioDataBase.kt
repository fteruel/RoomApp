package com.example.roomapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//declaro la base de datos. La entidad usando la class usuario
@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class usuarioDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    //creo un singleton para hacer una instancia central de la BD
    companion object {
        @Volatile
        private var INSTANCE: usuarioDataBase? = null

        fun getDatabase(context: Context): usuarioDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            //para mantener posibles entradas sincronizadas
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    usuarioDataBase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}