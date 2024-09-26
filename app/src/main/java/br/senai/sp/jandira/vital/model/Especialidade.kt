package br.senai.sp.jandira.vital.model

import androidx.compose.ui.graphics.painter.Painter

data class Especialidade(
    // Atributos
    var id: Int = 0,
    var nome: String = "",
    var descricao: String = "",
    var imagem_url: Painter?= null  // Para caso nao tenha imagem coloca null
)
