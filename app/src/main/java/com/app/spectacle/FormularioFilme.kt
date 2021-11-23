package com.app.spectacle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.app.spectacle.dao.FilmesDao
import com.app.spectacle.databinding.ActivityFormularioFilmeBinding
import com.app.spectacle.models.Filme

class FormularioFilme : AppCompatActivity() {
    private val binding by lazy{
        ActivityFormularioFilmeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_filme)
        setContentView(binding.root)
        configBotaoSalvar()
    }
    fun configBotaoSalvar(){
        val btnSalvar = binding.botaoSalvarFilme
        btnSalvar.setOnClickListener {
            salvarFilme()
        }
    }

    fun salvarFilme(){
        val textTitulo = binding.formFilmeTitulo
        val titulo = textTitulo.text.toString()
        val novoFilme = Filme(titulo = titulo)

        Log.i("FormularioFilme","titulo $titulo")
        val filme = FilmesDao().salvar(this, novoFilme)
        Log.i("FormularioFilme", "$filme")

        AlertDialog.Builder(this)
            .setTitle("Adicionado com sucesso")
            .setMessage("$titulo adiconado")
            .setPositiveButton("Ok"){_,_ -> finish()}
            .show()

    }
}