package com.uam.agenda.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onUsuario(usuario: String) {
        state = state.copy(usuario = usuario)
    }
    fun onPassword(password : String) {
        state = state.copy(password = password)
    }

    fun onLogin() {
        viewModelScope.launch{
            if (!(state.usuario.equals("admin")) ||
                    !(state.password.equals("123"))) {
                state.copy(
                    error = true,mensaje="Usuario Incorrecto"
                )
            }
            else {
                state.copy(
                    error = false,mensaje = "Usuario correcto"
                )
            }
        }
    }

    data class LoginState(
        val usuario: String = "",
        val password: String = "",
        val error:Boolean=false,
        val mensaje:String = ""
    )

}