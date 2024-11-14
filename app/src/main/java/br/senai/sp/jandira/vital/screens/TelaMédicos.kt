package br.senai.sp.jandira.vital.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.model.Medicos
import br.senai.sp.jandira.vital.model.ResultMedicos
import br.senai.sp.jandira.vital.service.RetrofitFactory
import br.senai.sp.jandira.vital.ui.theme.VitalTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TelaMedicos(controleDeNavegacao: NavHostController) {

    // Criando variaveis de estado

    // Lista de Médicos
    var medicosList = remember {
        mutableStateListOf<Medicos>()
    }

    // Efetuar a Requisicao da API
    LaunchedEffect(key1 = Unit) {
        val callMedicosList = RetrofitFactory()
            .getMedicoService()
            .getAllMedicos()

        callMedicosList.enqueue(object : Callback<ResultMedicos> {
            override fun onResponse(
                call: Call<ResultMedicos>,
                response: Response<ResultMedicos>
            ) {
                Log.d("API_RESPONSE", "Medicos recebidas: ${medicosList.size}")

                if (response.isSuccessful){
                    val medicos = response.body()?.medicos
                    medicos?.let {
                        medicosList.addAll(it)
                    }
                } else{
                    Log.d("API_ERROR", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ResultMedicos>, t: Throwable) {
                // Lidar com a falha na requisicao
            }
        })
    }

    VitalTheme {
        Surface{
            Box(
                modifier = Modifier
                    .background(
                        Color(0xFF2954C7),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    )
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 50.dp)
            ){

                // Icon clicavel
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .align(Alignment.CenterStart) // Alinha à esquerda, centralizado verticalmente
                        .padding(start = 16.dp) // Adiciona um espaçamento à esquerda
                        .clickable{
                            controleDeNavegacao.navigate("telaHome")
                        }
                )
                Text(
                    "Médicos",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.Center) // Centraliza no meio
                )

            }

            Column (
                modifier = Modifier
                    .padding(top = 180.dp)
            ) {
                // Campo de Pesquisa por especialidade
                OutlinedTextField(
                    value = "",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .width(360.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(Color(0xFFF6F6F6)),
                    placeholder = {
                        Text(
                            text = "Pesquise por médico",
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


                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalArrangement = Arrangement.Top
                ){
                    items(medicosList) {
                        MedicosCard(it)
                    }

                }
            }

        }
    }

}

@Composable
// Funcao para os cards dos medicos
fun MedicosCard(medicos: Medicos) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally // Centraliza o conteúdo dentro do Card
            ) {
                // Imagem do médico centralizada
                AsyncImage(
                    model = medicos.foto_medico,
                    contentDescription = "Foto do Médico",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp)) // Espaço entre a imagem e o conteúdo abaixo

                // Outros conteúdos podem ser adicionados aqui, como o nome do médico, especialidade, etc.
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally // Alinha o conteúdo do texto ao centro
                ) {
                    Text(
                        text = "Dr." + medicos.nome_medico,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF579EC5)
                    )
                    Text(
                        text = medicos.especialidade,
                        fontSize = 14.sp,
                        color = Color(0XFFA09C9C)
                    )
                }
            }
        }
    }






}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaMedicosPreview () {
    // Pre-visualizacao
    VitalTheme {
    }

}