package com.uam.agenda.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var usuario : String by mutableStateOf("")
    var password: String by mutableStateOf("")
    var error : Boolean by mutableStateOf(false)
    var mensaje : String by mutableStateOf("")

    fun onUsuario(usuario: String) {
        this.usuario = usuario;
    }
    fun onPassword(password : String) {
        this.password = password;
    }

    fun onLogin() {
        viewModelScope.launch{
            if (!(usuario.equals("admin")) ||
                    !(password.equals("123"))) {
                error = true;
                mensaje="Usuario incorrecto"
            }
            else {
                error = false
                mensaje = "Usuario correcto"
            }
        }
        println(mensaje)
    }


}