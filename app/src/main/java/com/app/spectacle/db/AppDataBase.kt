package com.app.spectacle.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.spectacle.dao.FilmesDao
import com.app.spectacle.models.Filme

@Database(entities = arrayOf(Filme::class), version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun filmeDao(): FilmesDao
}