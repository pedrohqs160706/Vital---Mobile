package br.senai.sp.jandira.vital.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.model.Login
import br.senai.sp.jandira.vital.model.UsuarioLogin
import br.senai.sp.jandira.vital.service.RetrofitFactory
import br.senai.sp.jandira.vital.ui.theme.VitalTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TelaCadastro(controleDeNavegacao: NavHostController) {

    // Criando variaves de estado


    var emailState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var erroLoginState = remember {
        mutableStateOf(false)
    }

    var mensagemErroState = remember {
        mutableStateOf("")
    }

    var isOverState = remember {
        // Tipo booleano
        mutableStateOf(false)
    }

//
//    var contaRepository = ContaRepository(LocalContext.current)

    VitalTheme {
        Column  {
            Surface(
                modifier = Modifier
                    .height(250.dp)
                    .offset(y = -15.dp)

            ){
                // Imagem da onda
                Image(
                    painter = painterResource(id = R.drawable.onda),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )

                Column  (
                    modifier = Modifier
                        .fillMaxSize()
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    // Imagem da logo
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "",
                        modifier = Modifier
                            .width(140.dp)
                            .height(110.dp)
                            .padding(top = 0.dp)
                    )
                }




            }

            Column (
                modifier = Modifier
                    .padding(top = 0.dp, start = 26.dp, end = 26.dp, bottom = 26.dp), // Reduzindo o padding superior
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(30.dp))


                Text(
                    text = "Criar Conta",
                    fontSize = 28.sp,
                    color = Color(0xFF2954C7)
                )
                // Espaco para inserir o email
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(text = "Nome")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))


                // Espaco para inserir o email
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = "Email")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = senhaState.value,
                    onValueChange = {
                        senhaState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = "CPF")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = senhaState.value,
                    onValueChange = {
                        senhaState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = "Sexo")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Face, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = senhaState.value,
                    onValueChange = {
                        senhaState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = "Senha")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = senhaState.value,
                    onValueChange = {
                        senhaState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = "Confirmar Senha")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column (
                    modifier = Modifier
                        .padding(16.dp)

                ) {
                    Button(
                       onClick = {

                        },
                        modifier = Modifier
                            .height(46.dp)
                            .width(300.dp)
                            .height(50.dp)
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
                    )
                    {
                        // Texto dentro do botao
                        Text(
                            text = "FINALIZAR",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
                Text(
                    text = "Já possui conta?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light

                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Entre aqui",
                    fontSize = 16.sp,
                    color = Color(0xFF0436D7),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .clickable {
                            if (controleDeNavegacao != null) {
                                controleDeNavegacao.navigate("telaLogin")
                            }
                        }

                )

            }


        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaCadastroPreview () {

    // Pre-visualizacao
    VitalTheme {
//        TelaCadastro(controleDeNavegacao)
    }


}