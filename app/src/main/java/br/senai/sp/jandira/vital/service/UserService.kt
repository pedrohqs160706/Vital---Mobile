package br.senai.sp.jandira.vital.service

import br.senai.sp.jandira.vital.model.Login
import br.senai.sp.jandira.vital.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    // Criar uma funcao para fazer a requisicao

    // Salvar o Usuario
    @Headers("Content-Type: application/json")
    @POST("usuario")
    fun salvarUsuario(@Body user: Usuario): Call<Usuario>


    // Login do Usuario
    @Headers("Content-Type: application/json")
    @POST("login/usuario")
    fun loginUsuario(@Body user: Usuario): Call<Login>



}