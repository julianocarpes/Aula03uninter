package com.example.aula03uninter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.aula03uninter.domain.LoginService
import com.example.aula03uninter.extencion.alert

class MainActivity: LogActivity(){
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState != null){
            Log.d("Ciclo de vida","Recuperando estado")
            count = savedInstanceState.getInt("count")
        }
        Log.d("Ciclo de vida", "Count:$count")

        findViewById<Button>(R.id.btnLogin).setOnClickListener{
            onclickLogin()
        }
        findViewById<TextView>(R.id.esqueciSenha).setOnClickListener{
            onclickEsqueciSenha()
        }
        findViewById<TextView>(R.id.Cadastrar).setOnClickListener{
            onclickCadastrar()
        }
        findViewById<TextView>(R.id.btLocalização).setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com.br"))
            startActivity(intent)
            finish()

        }
        findViewById<TextView>(R.id.btFaleConosco).setOnClickListener{
            onclickContato()
        }
    }

    private fun onclickContato() {
        startActivity(Intent(this, ContatoActivity:: class.java))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("Ciclo de vida ","Salvando estado")
        count++
        outState.putInt("count",count)
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
        //startActivity(Intent(this, HomeActivity::class.java))
            finish()  //tem que desabilitar no maifest o parentActivityNme
            val intent = Intent(this, HomeActivity:: class.java)
            val args = Bundle()
            //args.putString("nome", user.nome)// unico parametro
            args.putSerializable("usuario",user)
            intent.putExtras(args)
            startActivity(intent)
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