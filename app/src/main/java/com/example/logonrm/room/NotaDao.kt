package com.example.logonrm.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface NotaDao{

    @Insert
    fun criar(nota : Nota)

    @Update
    fun atualizar(nota: Nota)

    @Delete
    fun apagar(nota : Nota)

    @Query("SELECT * FROM nota")
    fun buscarTodos(): LiveData<List<Nota>>
}