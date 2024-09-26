package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.ui.theme.VitalTheme


@Composable
fun TelaBemVindo(modifier: Modifier = Modifier) {




        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF0174DE)),
            horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
            verticalArrangement = Arrangement.Center // Centraliza verticalmente

        ) {

            Spacer(modifier = Modifier.height(40.dp))


            Column (
                modifier =  Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
                verticalArrangement = Arrangement.Center // Centraliza verticalmente
            ) {
                Text(
                    text = "Bem vindo ao Vital+",
                    color = Color.White,
                    fontSize = 28.sp
                )
                Spacer(modifier = Modifier.height(10.dp))


                Text(
                    text = "Marque consultas em poucos minutos, tenha um atendimento mais prático e dinamico para melhorar a saúde",
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }




            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .width(290.dp)
                    .height(260.dp)
            )

            Spacer(modifier = Modifier.height(220.dp))


          // Botao de Entrar
            Column (
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
                verticalArrangement = Arrangement.Center // Centraliza verticalmente

            ) {
                // Botao para entrar
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(42.dp)
                        .width(280.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    // Texto dentro do botao
                    Text(
                        text = "Criar Conta",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF0073DE)

                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Já possui cadastro?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )


                Text(
                    text = "Entrar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White

                )
            }

        }





    }







@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaBemVindoPreview () {

    // Pre-visualizacao
    VitalTheme {
        TelaBemVindo()
    }


}