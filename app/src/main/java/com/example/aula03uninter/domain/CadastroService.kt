package com.example.aula03uninter.domain

import android.util.Log

class CadastroService {
    fun cadastrar(model: CadastroModel):Boolean{
        Log.d("[AULA4]","Cadastro $model")
        return true
    }

}