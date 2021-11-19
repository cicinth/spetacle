package com.app.spectacle.dao

import com.app.spectacle.models.Filme

class FilmesDao {

    fun salvar(filme: Filme){


    }

    fun buscarFilme() : List<Filme>{
        return filmes.toList()
    }

    companion object{
        private val filmes =  mutableListOf<Filme>()
    }
}