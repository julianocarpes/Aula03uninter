package com.example.aula03uninter.domain

class LoginService {
    fun login(login:String,senha:String):Usuario? {
        if (login == "juliano" && senha == "123") {
            return Usuario("Juliano", "a@a.com")
        } else if(login == "teste" && senha == "123") {
              return Usuario("Teste","b@b.com")
        }
        return null
    }
}