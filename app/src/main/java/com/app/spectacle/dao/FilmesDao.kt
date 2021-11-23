package com.app.spectacle.dao

import android.content.Context
import com.app.spectacle.db.DBHelper
import com.app.spectacle.models.Filme

class FilmesDao {

    private var db: DBHelper? = null

    fun salvar(contexto: Context, filme: Filme): Any{
        db = DBHelper(contexto)
        return db!!.insertFilme(filme)
    }

    fun buscarFilme(contexto: Context) : List<Filme>{
        db = DBHelper(contexto)
        return db!!.filmeList
    }

}