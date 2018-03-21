package com.example.logonrm.room

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.facebook.stetho.Stetho

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var notaViewModel: NotaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Stetho.initializeWithDefaults(this);

        notaViewModel = ViewModelProviders.of(this)
                .get(NotaViewModel::class.java)

        fab.setOnClickListener { view ->
            notaViewModel.criar(Nota(null,"Criar um novo app"))
        }

        notaViewModel.notas?.observe(this, Observer {
            notas -> for (nota in notas!!){
                Log.i("NOTA", nota.descricao)
            }
        })
    }
}
