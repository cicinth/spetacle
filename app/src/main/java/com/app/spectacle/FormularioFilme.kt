package com.app.spectacle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import coil.load
import com.app.spectacle.dao.FilmesDao
import com.app.spectacle.databinding.ActivityFormularioFilmeBinding
import com.app.spectacle.databinding.DialogCarregarImageBinding
import com.app.spectacle.models.Filme
import java.util.*

class FormularioFilme : AppCompatActivity() {
    private val binding by lazy{
        ActivityFormularioFilmeBinding.inflate(layoutInflater)
    }
    private var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_filme)
        setContentView(binding.root)
        configBotaoSalvar()
        carregarImage()
    }

    fun carregarImage(){
        binding.imageCarregar.setOnClickListener {
            val bindingCarregarImagem = DialogCarregarImageBinding.inflate(layoutInflater)
            bindingCarregarImagem.btnCarregarImage.setOnClickListener {
                url = bindingCarregarImagem.textImageUrl.text.toString()
                bindingCarregarImagem.imageCarregar.load(url)
            }
            AlertDialog.Builder(this)
                .setView(bindingCarregarImagem.root)
                .setPositiveButton("Ok"){_,_->
                    binding.imageCarregar.load(url)
                }
                .setNegativeButton("Cancelar"){_,_->}
                .show()
        }
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
        val uuid: UUID = UUID.randomUUID()
        val novoFilme = Filme(id = uuid.toString(), titulo = titulo, image =  url)

        Log.i("FormularioFilme","titulo $titulo")
        val filme = SpectacleApplication.database?.filmeDao()?.salvar(novoFilme)
        Log.i("FormularioFilme", "$filme")

        AlertDialog.Builder(this)
            .setTitle("Adicionado com sucesso")
            .setMessage("$titulo adiconado")
            .setPositiveButton("Ok"){_,_ -> finish()}
            .show()

    }
}