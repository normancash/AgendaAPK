package com.uam.agenda.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.agenda.model.ListAgenda
import com.uam.agenda.repository.RepositoryAgenda
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AgendaViewModel : ViewModel() {

    private val mstate = MutableStateFlow<_state>(_state())
    val _mstate : StateFlow<_state> = mstate

    val repository = RepositoryAgenda()


    data class _state (
        val loading : Boolean = false,
        val listData : ListAgenda = ListAgenda()
    )

    init {
        viewModelScope.launch {
            mstate.update { it.copy(loading = true) }
            val response = repository.getAll()
            if (response.isSuccess) {
               mstate.update { it.copy(listData = response.getOrNull()!!) }
            }
            mstate.update { it.copy(loading = false) }
        }
    }
}