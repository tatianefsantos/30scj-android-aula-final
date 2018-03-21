package com.example.logonrm.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Nota::class), version = 1)
abstract class NotaRoomDatabase : RoomDatabase(){

    abstract fun notaDao():NotaDao

    companion object {
        private var INSTANCE: NotaRoomDatabase? = null
        internal fun getDatabase(context: Context): NotaRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(NotaRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                NotaRoomDatabase::class.java, "nota_database")
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}