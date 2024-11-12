package br.senai.sp.jandira.vital.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Usuario(
    val nome: String = "",
    val email: String = "",
    val cpf: String = "",
    val id_sexo: Int = 0,
    val senha: String = "",
    val data_nascimento: String = "",
    val foto: String,
    val isOver: Boolean = false
)

//data class RespostaCadastro(
//    val status: String, // "success" ou "error"
//    val mensagem: String // Mensagem de sucesso ou erro
//)