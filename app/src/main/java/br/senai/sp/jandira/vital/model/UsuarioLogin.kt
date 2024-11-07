package br.senai.sp.jandira.vital.model

import com.google.firebase.firestore.auth.Token

data class UsuarioLogin(
    val usuario_id: Int = 0,
    val nome: String,
    val token: Token
)