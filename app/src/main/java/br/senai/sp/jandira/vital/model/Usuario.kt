package br.senai.sp.jandira.vital.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String = "",
    val email: String = "",
    val cpf: String = "",
    val id_sexo: Int = 0,
    val senha: String = "",
    val data_nascimento: String = "",
    @ColumnInfo(name = "is_over") val isOver: Boolean = false
)

