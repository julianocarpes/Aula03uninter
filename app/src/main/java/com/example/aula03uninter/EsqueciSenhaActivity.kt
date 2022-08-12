package com.example.aula03uninter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.aula03uninter.domain.EsqueciSenhaService
import com.example.aula03uninter.extencion.alert

class EsqueciSenhaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha)
        findViewById<Button>(R.id.btEnviar).setOnClickListener{
            onClickEnviar()
        }
    }
    private fun onClickEnviar(){
        val tLogin = findViewById<EditText>(R.id.tLogin)
        val login = tLogin.text.toString()
        val service = EsqueciSenhaService()
        val ok = service.recuperarSenha(login)
        if(ok){
            alert("Sua nova senha foi enviada para seu e-mail")
            finish()
        }
        else{
            alert("Ocorreu um eero ao recuperar a senha")
        }

    }

}