package com.example.aula03uninter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnLogin).setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
        }
        findViewById<TextView>(R.id.esqueciSenha).setOnClickListener{
            startActivity(Intent(this,EsqueciSenhaActivity::class.java))
        }
        findViewById<TextView>(R.id.Cadastrar).setOnClickListener{
            startActivity(Intent(this,CadastroActivity::class.java))
        }
    }
}