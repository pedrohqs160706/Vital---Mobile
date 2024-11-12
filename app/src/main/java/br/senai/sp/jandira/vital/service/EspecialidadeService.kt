package br.senai.sp.jandira.vital.service

import br.senai.sp.jandira.vital.model.ResultEspecialidade
import retrofit2.Call
import retrofit2.http.GET


interface EspecialidadeService {

    // Funcao para listar todos os personagens
    @GET("especialidade")
    fun getAllEspecialidades(): Call<ResultEspecialidade>  // Esse call vai me devolver uma lista de personagens

}