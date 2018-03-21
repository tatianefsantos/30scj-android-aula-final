package com.example.logonrm.room

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class NotaRepository (application: Application){

    val notaDao: NotaDao?
    val notas: LiveData<List<Nota>>?

    init {
        notaDao = NotaRoomDatabase
                .getDatabase(application)
                ?.notaDao()

        notas = notaDao?.buscarTodos()
    }

    fun criar(nota: Nota){
        insertAsyncTask(notaDao).execute(nota)
    }

    private class insertAsyncTask(private val mAsyncTaskDao: NotaDao?)
        : AsyncTask<Nota, Void, Void>() {

        override fun doInBackground(vararg params: Nota): Void? {
            mAsyncTaskDao?.criar(params[0])
            return null
        }
    }

}