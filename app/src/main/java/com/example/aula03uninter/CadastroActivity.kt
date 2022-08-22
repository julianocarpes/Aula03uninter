package com.example.aula03uninter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import com.example.aula03uninter.domain.CadastroModel
import com.example.aula03uninter.domain.CadastroService
import com.example.aula03uninter.extencion.alert

class CadastroActivity : LogActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        findViewById<Button>(R.id.btnCadastro).setOnClickListener{
        onClickCadastrar()
        }
    }
    private fun onClickCadastrar(){
        val termosOk = findViewById<CheckBox>(R.id.chekbox).isChecked
        if(!termosOk){
            alert("Aceite os termos para continuar")
        }else{
            val model = getCadastroModel()
            val service = CadastroService()
            val ok:Boolean = service.cadastrar(model)
            if(ok){
                alert("Cadastro realizado com sucesso !\nSua senha foi enviada para seu e-mail")
            }
            else{
                alert("Ocorreu um erro ao Cadastrar")
            }
        }
    }
    private fun getCadastroModel():CadastroModel{
        val model = CadastroModel()
        var radioSexo = findViewById<RadioGroup>(R.id.radiosexo)
        model.nome = findViewById<EditText>(R.id.editNome).text.toString()
        model.login = findViewById<EditText>(R.id.editeLogin).text.toString()
        model.email = findViewById<EditText>(R.id.editeEmail).text.toString()
        (if (radioSexo.getCheckedRadioButtonId() ==
            R.id.radioMasculino) {
            "M"
            } else {
            "F"
            }).also { model.sexo = it }
            return model
    }
}
