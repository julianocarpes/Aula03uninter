package com.example.aula03uninter

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import com.example.aula03uninter.extencion.alert

class ContatoActivity : LogActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val ok = PermissionUtils.request(this,arrayOf(Manifest.permission.CALL_PHONE))
        if(!ok){
            alert("Usuário ainda não aceitou a permissão")
        }
        setContentView(R.layout.activity_contato)
        findViewById<TextView>(R.id.btCelular).setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:984699201"))
            startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val ok = PermissionUtils.validate(this,permissions)
        if(ok){
            val intent  = Intent(Intent.ACTION_CALL, Uri.parse("tel:984699201"))
            startActivity(intent)
        }
    }
}
