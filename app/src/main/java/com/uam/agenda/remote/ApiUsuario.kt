package com.uam.agenda.remote

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiUsuario {

    @POST("usuario/login")
    suspend fun login(@Query("email") email : String,
                      @Query("password") password : String): Response<Int>
}