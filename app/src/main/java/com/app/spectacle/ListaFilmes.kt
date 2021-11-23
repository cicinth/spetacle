package com.app.spectacle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.spectacle.components.ListaFilmesAdapter
import com.app.spectacle.dao.FilmesDao
import com.app.spectacle.databinding.ActivityListaFilmesBinding
import com.app.spectacle.databinding.ListaFilmesBinding
import com.app.spectacle.models.Filme

class ListaFilmes : AppCompatActivity(R.layout.activity_lista_filmes) {
    private val binding by lazy {
        ActivityListaFilmesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        configBotaoNovoFilme()
        configRecycleView()
    }
    fun configBotaoNovoFilme(){
        val btnAddNovoFilme = binding.btnAddFilme
        btnAddNovoFilme.setOnClickListener {
            val intent = Intent(this, FormularioFilme::class.java)
            startActivity(intent)
        }
    }
    fun configRecycleView(){
        val filmes : List<Filme>? = SpectacleApplication.database?.filmeDao()?.buscarFilme()
        Log.i("ListaFilmes", "$filmes")
        val filmesView = binding.listaFilmes
        filmesView.adapter = filmes?.let { ListaFilmesAdapter(it, this) }
    }
}