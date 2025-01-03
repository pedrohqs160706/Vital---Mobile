package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.ui.theme.VitalTheme


@Composable
fun InfoMedico(controleDeNavegacao: NavHostController) {



    VitalTheme {

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xffC6E1FF)),
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                "Dr. Lara Silva Costa",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .offset(y = 180.dp, x = 10.dp)
            )

            Text(
                "Dermatologista",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                modifier = Modifier
                    .offset(y = 183.dp, x = 10.dp)
            )


            Row {
                Image(
                    painter = painterResource(R.drawable.estrelaazul),
                    contentDescription = "",
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp)
                        .offset(y = 197.dp, x = 10.dp)
                )

                Text(
                    "4.8",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Color(0xff565454),
                    modifier = Modifier
                        .offset(y = 195.dp, x = 14.dp)
                )

                Text(
                    "(388 avaliações)",
                    fontWeight = FontWeight.Light,
                    fontSize = 8.sp,
                    color = Color(0xffA09C9C),
                    modifier = Modifier
                        .offset(y = 195.dp, x = 14.dp)
                )
            }

            Image(
                painter = painterResource(R.drawable.medica),
                contentDescription = "",
                modifier = Modifier
                    .width(242.dp)
                    .height(300.dp)
                    .align(Alignment.End)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )
                    .align(Alignment.CenterHorizontally)


            ) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                        )
                ) {

                    Text(
                        "Sobre",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color(0xff565454),
                        modifier = Modifier
                            .padding(start = 26.dp, top = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        "Trabalho na area com muita experiencia e profissionalismo, atendo de forma dinamica. Posso ajudar voce...",
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(start = 21.dp, end = 30.dp)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        "100 Avaliações",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xff565454),
                        modifier = Modifier
                            .padding(start = 26.dp)
                    )

                    Spacer(modifier = Modifier.height(15.dp))


                    Column (
                        modifier = Modifier
                            .width(312.dp)
                            .height(110.dp)
                            .background(
                                color = Color(0xffC6E1FF),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .align(Alignment.CenterHorizontally)
                    ){
                        Row {

                            Text(
                                "Julia P.",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(start = 22.dp, top = 10.dp)
                            )

                            Spacer(modifier = Modifier.width(119.dp))

                            Text(
                                "15 Out 2023",
                                fontSize = 8.sp,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            )

                            Spacer(modifier = Modifier.width(3.dp))

                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp, end = 10.dp)
                            )
                        }

                        Text(
                            "Uma excelente médica, trabalha com dedicação, cuidado e profissionalismo. Todas minhas consultas são com ela, nunca mais marco com outra pessoa, ela mudou a minha vida e a minha saúde",
                            fontSize = 10.sp,
                            lineHeight = 10.sp,
                            color = Color(0x50565454),
                            modifier = Modifier
                                .padding(14.dp)

                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Column (
                        modifier = Modifier
                            .width(312.dp)
                            .height(70.dp)
                            .background(
                                color = Color(0xffC6E1FF),
                                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                            )
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Row {

                            Text(
                                "Vinicius G.",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(start = 22.dp, top = 10.dp)
                            )

                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                "15 Out 2023",
                                fontSize = 8.sp,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            )

                            Spacer(modifier = Modifier.width(3.dp))

                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrela),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.estrelaapagada),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 13.dp)
                            )
                        }

                        Text(
                            "Uma excelente médica, trabalha com dedicação, cuidado e profissionalismo. Todas minhas consultas são com ela, nunca mais marco com outra pessoa, ela mudou a minha vida e a minha saúde",
                            fontSize = 10.sp,
                            lineHeight = 10.sp,
                            color = Color(0x50565454),
                            modifier = Modifier
                                .padding(14.dp)

                        )



                    }

                    Column (
                        modifier = Modifier
                            .padding(16.dp)
                            .padding(top = 80.dp)
                    ) {
                        Button(
                            onClick = {
                            /*TODO*/
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(43.dp)
                                .align(alignment = Alignment.CenterHorizontally)
                                .background(
                                    color = Color(0xFF0174DE),
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent // Para garantir que o gradiente seja visível
                            )

                        ) {

                            Text(
                                text = "Selecione o dia e a hora",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                        }
                    }


                }



            }
        }
    }


}



@Preview (showBackground = true, showSystemUi = true)
@Composable
fun InfoMedicoPreview () {


    // Pre-visualizacao
    VitalTheme {
        InfoMedico(rememberNavController())
    }




}