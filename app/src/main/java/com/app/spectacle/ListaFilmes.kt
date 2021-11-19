package com.app.spectacle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.spectacle.components.ListaFilmesAdapter
import com.app.spectacle.dao.FilmesDao
import com.app.spectacle.databinding.ActivityListaFilmesBinding
import com.app.spectacle.databinding.ListaFilmesBinding

class ListaFilmes : AppCompatActivity(R.layout.activity_lista_filmes) {
    private val binding by lazy {
        ActivityListaFilmesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecycleView()
    }

    fun configRecycleView(){
        val filmesView = binding.listaFilmes
        filmesView.adapter = ListaFilmesAdapter(FilmesDao().buscarFilme(), this)
    }
}