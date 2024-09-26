package br.senai.sp.jandira.vital.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.model.Login
import br.senai.sp.jandira.vital.model.Usuario
import br.senai.sp.jandira.vital.repository.CategoriaRepository
import br.senai.sp.jandira.vital.repository.EspecialidadeRepository
import br.senai.sp.jandira.vital.service.RetrofitFactory
import br.senai.sp.jandira.vital.ui.theme.VitalTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun TelaHome() {

    // Criando variaves de estado

    val categoria = CategoriaRepository().mostrarTodasAsCategorias()

    val especialidades = EspecialidadeRepository().listarTodasAsEspecialidades()

    var especialidadeState= remember {
        mutableStateOf("")
    }

    Column {

        Surface (
            modifier = Modifier
                .height(210.dp)
        ) {
            // Fundo
            Image(
                painter = painterResource(id = R.drawable.fundo),
                contentDescription = "Fundo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                // Colocar borda arredondada

            )
            Column {
                // Foto de Perfil
                Image(
                    // Fazer a foto de perfil vir do back
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = "Foto de Perfil",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .offset(x = 330.dp, y = 13.dp)

                )

                Text(
                    text = "Olá, Júlia",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .offset(x = 280.dp, y = 110.dp)
                )

            }

        }
        Spacer(modifier = Modifier.height(14.dp))

// Categorias
        Column {
            Text(
                text = "Categorias",
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = Color(0xFF565454),
                modifier = Modifier
                    .offset(x = 10.dp)
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow {
            items(categoria){
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .width(140.dp)
                        .offset(x = 10.dp)
                        .padding(horizontal = 6.dp),
                    // Se o card estiver selecionado (true a cor dele vai ser mais escura)
                    colors = if (it.selecionado==true) CardDefaults.cardColors(containerColor = Color(0xFF2954C7))
                    // Se nao estiver selecionado a opacidade será menor
                    else CardDefaults.cardColors(containerColor = Color(0x802954C7))
                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    ) {
                        // Imagem de cada categoria
                        Image(
                            painter = if (it.imagem==null) painterResource(id = R.drawable.notimage) else it.imagem!!,
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .width(60.dp)
                                .height(45.dp)
                        )
                        Text(
                            text = it.titulo,
                            color = Color.White,
                            fontSize = 14.sp
                        )

                    }


                }

            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Card (
            elevation = CardDefaults.cardElevation(7.dp),
            shape = RoundedCornerShape(23.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(48.dp)
        ){
            // Campo de Pesquisa por especialidade
            OutlinedTextField(
                value = especialidadeState.value,
                onValueChange = {
                    especialidadeState.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 0.dp),
                placeholder = {
                    Text(
                        text = "Pesquise por especialidade",
                        color = Color(0xFFA09C9C)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Search ,
                            contentDescription = "",
                            tint = Color(0xFFA09C9C)
                        )
                        
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))


        // Especialidades
//        LazyColumn {
//            items(especialidades){
//                Card(
//                    elevation = CardDefaults.cardElevation(6.dp),
//                    colors = CardDefaults.cardColors(Color.White),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(10.dp)
//                ) {
//                    Column (
//                        modifier = Modifier
//                            // Vai ter a largura do pai dela (Card)
//                            .fillMaxSize()
//                            .padding(4.dp)
//                    ) {
//
//                        Image(
//                            painter = if (it.imagem_url == null) painterResource(id = R.drawable.notimage) else it.imagem_url!!,
//                            contentDescription = "",
//                            contentScale = ContentScale.Crop
//                        )
//
//                    }
//
//                }
//            }
//        }




    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaHomePreview () {

    // Pre-visualizacao
    VitalTheme {
        TelaHome()
    }


}