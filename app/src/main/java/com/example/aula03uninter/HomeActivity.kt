package com.example.aula03uninter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aula03uninter.domain.Usuario
import kotlinx.android.synthetic.main.activity_home.*
class HomeActivity :AppCompatActivity()  { //LogActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val args = intent.extras
        val user = args?.getSerializable("nome") as Usuario
        tNome.text = user.nome
    }
}