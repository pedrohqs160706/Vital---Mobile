package br.senai.sp.jandira.vital.service

import br.senai.sp.jandira.vital.model.ResultEspecialidade
import retrofit2.Call
import retrofit2.http.GET


interface EspecialidadeService {

    // Funcao para listar todas as especialidades
    @GET("especialidade")
    fun getAllEspecialidades(): Call<ResultEspecialidade>  // Esse call vai me devolver uma lista de personagens

}