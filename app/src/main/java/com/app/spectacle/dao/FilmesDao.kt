package com.app.spectacle.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.spectacle.models.Filme

@Dao
interface FilmesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun salvar(filme: Filme)

    @Query("SELECT * FROM filmes")
    fun buscarFilme() : List<Filme>

}