package com.app.spectacle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.app.spectacle.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botaoFilme = binding.cardFilme.acaoFilme
        setContentView(binding.root)

        val firebase = FirebaseAuth.getInstance()

//        firebase.createUserWithEmailAndPassword("cinthia@teste12.com", "teste1234").addOnSuccessListener {
//            Toast.makeText(this, "Usuario criado com sucesso", Toast.LENGTH_LONG).show()
//        }.addOnFailureListener {
//            Toast.makeText(this, "Erro na criação do usuario $it", Toast.LENGTH_SHORT).show()
//            Log.e("Cadastro", "Falha no cadastro", it)
//        }

//        firebase.signInWithEmailAndPassword("cinthia@teste12.com", "teste1234").addOnSuccessListener {
//            Toast.makeText(this, "Usuario logado", Toast.LENGTH_LONG).show()
//        }.addOnFailureListener {
//            Toast.makeText(this, "Falha de login", Toast.LENGTH_LONG).show()
//        }

        val usuarioFirebase: FirebaseUser? = firebase.currentUser
        if(usuarioFirebase != null){
            Toast.makeText(this, "Usuario esta logado $usuarioFirebase", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Nenhum usuario logado", Toast.LENGTH_LONG).show()
        }

        firebase.signOut()

        botaoFilme.setOnClickListener {
            val intent = Intent(this, ListaFilmes::class.java)
            startActivity(intent)
        }
    }
}