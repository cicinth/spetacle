package com.app.spectacle

import android.app.Application
import androidx.room.Room
import com.app.spectacle.db.AppDataBase

@SuppressWarnings("WeakerAccess")
class SpectacleApplication:Application() {
    @Override
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDataBase::class.java, "spectacle")
            .allowMainThreadQueries().build()
    }

    companion object{
        var database: AppDataBase? = null
    }
}