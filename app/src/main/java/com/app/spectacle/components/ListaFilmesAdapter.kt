package com.app.spectacle.components

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.spectacle.databinding.ActivityListaFilmesBinding
import com.app.spectacle.databinding.ListaFilmesBinding
import com.app.spectacle.models.Filme

class ListaFilmesAdapter(
    private val filmes: List<Filme>,
    private val context: Context
) : RecyclerView.Adapter<ListaFilmesAdapter.ViewHolder>(){
    class ViewHolder(binding: ListaFilmesBinding): RecyclerView.ViewHolder(binding.root){
        private val titulo = binding.recycleTituloFilme
        fun vincular(filme: Filme){
            titulo.text = filme.titulo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListaFilmesBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.vincular(filme)
    }

    override fun getItemCount(): Int  = filmes.size
}