package com.app.spectacle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.spectacle.databinding.ActivityListaFilmesBinding
import com.app.spectacle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botaoFilme = binding.cardFilme.acaoFilme
        setContentView(binding.root)

        botaoFilme.setOnClickListener {
            val intent = Intent(this, ListaFilmes::class.java)
            startActivity(intent)
        }
    }
}