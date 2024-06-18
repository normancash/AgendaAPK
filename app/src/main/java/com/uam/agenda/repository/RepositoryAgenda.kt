package com.uam.agenda.repository

import android.util.Log
import com.uam.agenda.model.ListAgenda
import com.uam.agenda.remote.ApiAdapter
import com.uam.agenda.remote.ApiAgenda
import com.uam.agenda.remote.ApiUsuario
import retrofit2.Response

class RepositoryAgenda {
    val apiAgenda : ApiAgenda by lazy {
        ApiAdapter.getInstance().create(ApiAgenda :: class.java)
    }

    suspend fun getAll() : Result<ListAgenda> {
        val retorno : ListAgenda
        return try {
            val response : Response<ListAgenda> = apiAgenda.getAll()
            retorno = response.body() as ListAgenda
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }
}