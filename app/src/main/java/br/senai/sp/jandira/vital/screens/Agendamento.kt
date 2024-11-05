package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.ui.theme.VitalTheme
import okhttp3.internal.wait


@Composable
fun Agendamento() {



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

                Text(
                    "Escolha o dia",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff565454),
                    modifier = Modifier
                        .padding(start = 25.dp, top = 25.dp, bottom = 3.dp)
                )


                Row {
                    Text(
                        "<",
                        color = Color(0x50565454),
                        modifier = Modifier
                            .padding(start = 25.dp)
                    )

                    Text(
                        "Agosto - 2024 >",
                        fontSize = 10.sp,

                        )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {

                    Spacer(modifier = Modifier.width(42.dp))

                    Column(
                        modifier = Modifier
                            .width(45.dp)
                            .height(47.dp)
                            .background(color = Color(0xff0174DE), shape = RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            "Hoje",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "20",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .width(45.dp)
                            .height(47.dp)
                            .background(color = Color(0xffBCBCBC), shape = RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            "Qua",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "20",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .width(45.dp)
                            .height(47.dp)
                            .background(color = Color(0xffBCBCBC), shape = RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            "Qui",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "20",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .width(45.dp)
                            .height(47.dp)
                            .background(color = Color(0xffBCBCBC), shape = RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            "Sex",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "20",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .width(45.dp)
                            .height(47.dp)
                            .background(color = Color(0xffD9D9D9), shape = RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            "Seg",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "20",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .width(45.dp)
                            .height(47.dp)
                            .background(color = Color(0xffBCBCBC), shape = RoundedCornerShape(10.dp))
                    ) {
                        Text(
                            "Ter",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "20",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ){

                    Row (
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ){

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "09:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .background(color = Color(0xff0174DE), shape = RoundedCornerShape(10.dp))

                        ){

                            Text(
                                "10:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .background(color = Color(0xffE3E3E3), shape = RoundedCornerShape(10.dp))

                        ){

                            Text(
                                "09:30 pm",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0x24565454),
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "09:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                    }

                    Row (
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 10.dp)
                    ){
                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "09:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "10:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "09:30 pm",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "09:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                    }

                    Row (
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp)
                    ){
                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "08:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "11:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .background(color = Color(0xffE3E3E3), shape = RoundedCornerShape(10.dp))

                        ){

                            Text(
                                "09:30 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0x24565454),
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Box (
                            modifier = Modifier
                                .width(68.dp)
                                .height(40.dp)
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffBCBCBC), // Cor da borda
                                    shape = RoundedCornerShape(10.dp) // A mesma forma da borda
                                )

                        ){

                            Text(
                                "12:00 am",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { /* Ação ao clicar no botão */ },
                    modifier = Modifier
                        .padding(16.dp) // Espaçamento ao redor do botão
                        .height(43.dp) // Altura do botão
                        .width(318.dp) // Largura do botão
                        .align(Alignment.CenterHorizontally)
                        .shadow(2.dp, shape = RoundedCornerShape(12.dp)), // Sombra com elevação de 8dp e cantos arredondados
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0174DE)), // Cor de fundo do botão
                    shape = RoundedCornerShape(12.dp) // Cantos arredondados no botão
                ) {
                    Text(
                        text = "Ir para pagamento",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }





            }
        }
    }


}



@Preview (showBackground = true, showSystemUi = true)
@Composable
fun AgendamentoPreview () {


    // Pre-visualizacao
    VitalTheme {
        Agendamento()
    }




}