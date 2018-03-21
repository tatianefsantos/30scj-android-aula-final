package com.example.logonrm.room

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class NotaViewModel(application: Application) : AndroidViewModel(application){

    val mRepository: NotaRepository = NotaRepository(application)
    val notas: LiveData<List<Nota>>?

    init {
        notas = mRepository.notas
    }

    fun criar(nota: Nota){
        mRepository.criar(nota)
    }
}