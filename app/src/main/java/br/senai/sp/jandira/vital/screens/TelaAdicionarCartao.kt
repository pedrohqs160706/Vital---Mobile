package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.ui.theme.VitalTheme

@Composable
fun TelaAdicionarCartao(controleDeNavegacao: NavHostController) {

    VitalTheme {
        Surface {
            Box(
                modifier = Modifier
                    .background(
                        Color(0xFF2954C7),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    )
                    .fillMaxWidth()
                    .height(100.dp)
            ){

                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .align(Alignment.CenterStart) // Alinha à esquerda, centralizado verticalmente
                        .padding(start = 16.dp) // Adiciona um espaçamento à esquerda
                )
                Text(
                    "Adicionar Cartão",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.Center) // Centraliza no meio
                )



            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {
//                        novasenhaState.value = it
                    },
//                    isError = erroState.value,
                    modifier = Modifier
                        .padding(30.dp)
                        .padding(top = 160.dp),

                    shape = RoundedCornerShape(26.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2954C7),
                        unfocusedBorderColor = Color(0xFFA09C9C)
                    ),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {
//                        novasenhaState.value = it
                    },
//                    isError = erroState.value,
                    label = {
                        Text(
                            text = "Confirmar Nova Senha",
                            fontSize = 13.sp
                        )
                    },
                    shape = RoundedCornerShape(26.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2954C7),
                        unfocusedBorderColor = Color(0xFFA09C9C)
                    ),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFF2954C7))
                    }

                )



//                Botao para Salvar a alteracao
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Bottom // Posiciona os elementos no final da tela
                ) {
                    Spacer(modifier = Modifier.weight(1f)) // Um espaço vazio que empurra o botão para baixo

                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .height(48.dp)
                            .width(266.dp)
                            .align(Alignment.CenterHorizontally) // Centraliza o botão horizontalmente
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF77B8FF), Color(0xFF0133D6))
                                ),
                                shape = RoundedCornerShape(30.dp) // Define o formato do botão
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent // Para garantir que o gradiente seja visível
                        ),
                        contentPadding = PaddingValues() // Remove o padding padrão para o gradiente preencher todo o botão
                    ) {
                        Text(text = "SALVAR")
                    }
                }



            }

        }
    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaAdicionarCartaoPreview () {


    // Pre-visualizacao
    VitalTheme {
        TelaAdicionarCartao(controleDeNavegacao= NavHostController(LocalContext.current))
    }



}