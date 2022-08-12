package com.example.aula03uninter

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.aula03uninter.domain.LoginService
import com.example.aula03uninter.extencion.alert
import org.w3c.dom.Text

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnLogin).setOnClickListener{
            onclickLogin()
        }
        findViewById<TextView>(R.id.esqueciSenha).setOnClickListener{
            onclickEsqueciSenha()
        }
        findViewById<TextView>(R.id.Cadastrar).setOnClickListener{
            onclickCadastrar()
        }

    }
    private fun onclickLogin(){
        val tlogin = findViewById<TextView>(R.id.editeUsuario)
        val tsenha = findViewById<TextView>(R.id.editSenhaLogin)

        val login = tlogin.text.toString()
        val senha = tsenha.text.toString()
        Log.d("[AULA4]","Login:$login, senha:$senha")

       /* if (login == "juliano" && senha == "123") {
            startActivity(Intent(this, HomeActivity::class.java))}*/

        val service = LoginService()
        val user = service.login(login, senha)
        if(user!=null){
        startActivity(Intent(this, HomeActivity::class.java))
            finish() // tem que desabilitar no maifest o parentActivityNme
        }else{
            /*val saida = findViewById<TextView>(R.id.saida)
            saida.setText("Usuario ou senha Incorretos")
            val dialog = AlertDialog.Builder(this).create()
            dialog.setTitle("Android")
            dialog.setMessage("Login Incorreto! Realize o cadastro")
            dialog.setButton(
                AlertDialog.BUTTON_NEUTRAL,"ok"){ _, which ->dialog.dismiss()
            }
            dialog.show()*/
            alert("Login Incorreto ! Cadastre-se")
        }
    }
    private fun onclickEsqueciSenha(){
        startActivity(Intent(this,EsqueciSenhaActivity::class.java))
    }
    private fun onclickCadastrar(){
        startActivity(Intent(this,CadastroActivity::class.java))
    }

}