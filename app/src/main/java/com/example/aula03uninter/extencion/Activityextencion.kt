package com.example.aula03uninter.extencion

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.alert(msg:String, callback:() -> Unit = {}){
    val dialog = AlertDialog.Builder(this).create()
    dialog.setTitle("Android")
    dialog.setMessage(msg)
    dialog.setButton(
        AlertDialog.BUTTON_NEUTRAL,"ok"){_
        , which ->dialog.dismiss()
        callback()
    }
    dialog.show()
}


