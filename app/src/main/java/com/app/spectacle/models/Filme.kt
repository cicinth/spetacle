package com.app.spectacle.models

data class Filme(val id: Int? = 0, val titulo : String){
    companion object {
        val TABLE_NAME = "filme"
        val ID_COLUMN = "id"
        val TITULO_COLUMN = "titulo"

        val CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT," + TITULO_COLUMN + " TEXT)")
    }
}
