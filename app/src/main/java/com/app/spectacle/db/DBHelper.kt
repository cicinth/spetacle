package com.app.spectacle.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.spectacle.models.Filme

private val DB_NAME = "spectacle_db"
class DBHelper(contexto: Context) : SQLiteOpenHelper(contexto, DB_NAME,null, 1 ) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(Filme.CREATE_TABLE)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS" + Filme.TABLE_NAME)
        }
        onCreate(db)
    }
    fun insertFilme(filme: Filme): Long{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Filme.TITULO_COLUMN, filme.titulo)
        val filme = db.insert(Filme.TABLE_NAME, null, values)

        db.close()

        return filme
    }

}