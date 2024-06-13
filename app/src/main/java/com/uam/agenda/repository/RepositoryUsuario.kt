package com.uam.agenda.repository

import android.util.Log
import com.uam.agenda.remote.ApiAdapter
import com.uam.agenda.remote.ApiUsuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import retrofit2.Response

class RepositoryUsuario : CoroutineScope by MainScope() {
    val apiUsuario : ApiUsuario by lazy {
        ApiAdapter.getInstance().create(ApiUsuario :: class.java)
    }

    suspend fun login(email:String,password : String) : Result<Int> {
        val retorno : Int
        return try {
            val response : Response<Int> = apiUsuario.login(email,password)
            retorno = response.body() as Int
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }

}