package com.uam.agenda.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.agenda.repository.RepositoryUsuario
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = RepositoryUsuario()

    var _state by mutableStateOf(LoginState())
        private set

    fun onEmail(email: String) {
        _state = _state.copy(email = email)
    }
    fun onPassword(password : String) {
        _state = _state.copy(password = password)
    }

    fun onLogin() {
        viewModelScope.launch{
            val result = repository.login(_state.email,_state.password)
            if (result.isSuccess) {
                if (result.getOrNull() == 1) {
                    _state.copy(
                        error = false, mensaje = "Usuario correcto"
                    )
                }
                else {
                    _state.copy(
                        error = true,mensaje="Usuario Incorrecto"
                    )
                }
            }
            else {
                _state.copy(
                    error = true,mensaje="Usuario Incorrecto"
                )
            }
        }
    }

    data class LoginState(
        val email: String = "",
        val password: String = "",
        val error:Boolean=false,
        val mensaje:String = ""
    )

}