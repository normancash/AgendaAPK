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
            _state = if (result.isSuccess) {
                        if (result.getOrNull() == 1) {
                            _state.copy(
                                error = false, message = "Usuario correcto")
                        }
                        else {
                            _state.copy(
                            error = true,message="Usuario Incorrecto")
                     }
                    }
                    else {
                        _state.copy(
                            error = true,message="Problemas con la red")
                    }
        }
    }

    fun restartState() {
        _state = _state.copy(error = false,message = null)
    }

    data class LoginState(
        val email: String = "",
        val password: String = "",
        val error:Boolean=false,
        val message:String? = null
    )

}