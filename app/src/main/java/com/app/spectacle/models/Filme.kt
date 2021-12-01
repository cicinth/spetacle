package com.app.spectacle.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "filmes")
data class Filme(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "titulo_filme")
    val titulo : String,
    val image: String? = null
)
