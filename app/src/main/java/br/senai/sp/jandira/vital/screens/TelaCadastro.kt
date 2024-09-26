package br.senai.sp.jandira.vital.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import br.senai.sp.jandira.vital.service.RetrofitFactory
import br.senai.sp.jandira.vital.ui.theme.VitalTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TelaCadastro() {

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
                    .padding(bottom = 40.dp)
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

                // Imagem da logo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .width(140.dp)
                        .height(110.dp)
                        .offset(x = 130.dp, y = 2.dp)
                )


            }

            Column (
                modifier = Modifier
                    .padding(start = 46.dp, end = 46.dp)
                    .offset(y = -40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(

                    text = "Criar Conta",
                    fontSize = 28.sp,
                    color = Color(0xFF2954C7)
                )

                Spacer(modifier = Modifier.height(7.dp))


//              espaço para inserir nome
                OutlinedTextField(
                    value = "",
                    onValueChange = {
                        emailState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier

                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Nome",
                            fontSize = 13.sp
                        )
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )

                // Espaco para inserir o email
                OutlinedTextField(
                    value = "",
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

                OutlinedTextField(
                    value = "",
                    onValueChange = {
                        emailState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = "CPF")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Face, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )

//              espaço para inserir sexo
                OutlinedTextField(
                    value = "",
                    onValueChange = {
                        emailState.value = it
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

                //espaço para inserir senha
                OutlinedTextField(
                    value = "",
                    onValueChange = {
                        emailState.value = it
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

                OutlinedTextField(
                    value = "",
                    onValueChange = {
                        emailState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = "Confirmar senha")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFF2954C7))
                    }
                )
                Column {
                    Checkbox(
                        modifier = Modifier
                            .padding(end = 280.dp),
                        checked = isOverState.value,
                        onCheckedChange = {
                            isOverState.value = it
                        },
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.Gray,
                            checkedColor = Color.Gray
                        )


                    )
                    Text(
                        text = "Eu concordo",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .offset(x = 30.dp, y = -35.dp)

                    )
                }


                Column (
                    modifier = Modifier
                        .offset(y = -25.dp)
                ) {
                    Button(
                        onClick = {

                            val login = Usuario(
                                email = emailState.value,
                                senha = senhaState.value
                            )
                            RetrofitFactory().getUserService().loginUsuario(login).enqueue(
                                object :
                                    Callback<Login> {
                                    override fun onResponse(p0: Call<Login>, res: Response<Login>) {
                                        Log.i("Response:", res.toString())
                                    }

                                    override fun onFailure(p0: Call<Login>, res: Throwable) {
                                        Log.i("Response:", res.toString())
                                    }

                                })
                        },
                        modifier = Modifier
                            .height(38.dp)
                            .width(266.dp)
//                            .offset(x = 20.dp, y = 10.dp)
                            .height(50.dp),



                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2954C7)),
                        shape = RoundedCornerShape(16.dp)
                    ) {

                        // Texto dentro do botao
                        Text(
                            text = "PRÓXIMO",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black

                        )

                    }


                }

                Text(
                    modifier = Modifier,
                    text = "Já possui conta?",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light

                )

                Text(
                    modifier = Modifier,
                    text = "Entre aqui",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF2954C7)

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
        TelaCadastro()
    }


}