//package br.senai.sp.jandira.vital.screens
//
//import android.util.Log
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Face
//import androidx.compose.material.icons.filled.Lock
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import br.senai.sp.jandira.vital.R
//import br.senai.sp.jandira.vital.model.RespostaCadastro
//import br.senai.sp.jandira.vital.model.Usuario
//import br.senai.sp.jandira.vital.service.RetrofitFactory
//import br.senai.sp.jandira.vital.ui.theme.VitalTheme
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TelaCadastro(controleDeNavegacao: NavHostController) {
//    val context = LocalContext.current
//    val usuarioService = RetrofitFactory().getUserService()
//
//    var nomeState by remember { mutableStateOf("") }
//    var emailState by remember { mutableStateOf("") }
//    var cpfState by remember { mutableStateOf("") }
//    var sexoSelecionadoState by remember { mutableStateOf(0) }
//    var senhaState by remember { mutableStateOf("") }
//    var confirmarSenhaState by remember { mutableStateOf("") }
//    var dataNascimentoState by remember { mutableStateOf("") }
//    var erroLoginState by remember { mutableStateOf(false) }
//    var mensagemErroState by remember { mutableStateOf("") }
//    var isOverState by remember { mutableStateOf(false) }
//    var expanded by remember { mutableStateOf(false) }
//    val sexos = listOf("Masculino", "Feminino", "Outro")
//
//    VitalTheme {
//        Column {
//            Surface(
//                modifier = Modifier
//                    .height(250.dp)
//                    .offset(y = -15.dp)
//
//            ) {
//                // Imagem da onda
//                Image(
//                    painter = painterResource(id = R.drawable.onda),
//                    contentDescription = "",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .fillMaxSize()
//
//                )
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    // Imagem da logo
//                    Image(
//                        painter = painterResource(id = R.drawable.logo),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .width(140.dp)
//                            .height(110.dp)
//                            .padding(top = 0.dp)
//                    )
//                }
//
//
//            }
//
//            Column(
//                modifier = Modifier
//                    .padding(top = 0.dp, start = 26.dp, end = 26.dp, bottom = 26.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                Spacer(modifier = Modifier.height(30.dp))
//
//                Text(
//                    text = "Criar Conta",
//                    fontSize = 28.sp,
//                    color = Color(0xFF2954C7)
//                )
//
//                OutlinedTextField(
//                    value = nomeState,
//                    onValueChange = { nomeState = it },
//                    isError = erroLoginState,
//                    modifier = Modifier
//                        .padding(top = 40.dp)
//                        .fillMaxWidth(),
//                    label = { Text(text = "Nome") },
//                    shape = RoundedCornerShape(26.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Filled.Person,
//                            contentDescription = "",
//                            tint = Color(0xFF2954C7)
//                        )
//                    }
//                )
//                Spacer(modifier = Modifier.height(10.dp))
//
//                OutlinedTextField(
//                    value = emailState,
//                    onValueChange = { emailState = it },
//                    isError = erroLoginState,
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    label = { Text(text = "Email") },
//                    shape = RoundedCornerShape(26.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Filled.Email,
//                            contentDescription = "",
//                            tint = Color(0xFF2954C7)
//                        )
//                    }
//                )
//                Spacer(modifier = Modifier.height(10.dp))
//
//                OutlinedTextField(value = cpfState,
//                    onValueChange = { cpfState = it },
//                    isError = erroLoginState,
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    label = { Text(text = "CPF") },
//                    shape = RoundedCornerShape(26.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Filled.Person,
//                            contentDescription = "",
//                            tint = Color(0xFF2954C7)
//                        )
//                    }
//                )
//                Spacer(modifier = Modifier.height(10.dp))
//
//                // Dropdown para seleção de sexo
//                OutlinedTextField(
//                    value = if (sexoSelecionadoState == 0) "" else sexos[sexoSelecionadoState - 1],
//                    onValueChange = { }, // Não é necessário onValueChange aqui
//                    readOnly = true, // Torna o campo somente leitura
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { expanded = true },
//                    label = { Text(text = "Sexo") },
//                    shape = RoundedCornerShape(26.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Filled.Face,
//                            contentDescription = "",
//                            tint = Color(0xFF2954C7)
//                        )
//                    },
//                    trailingIcon = {
//                        // Icon(Icons.Filled.ArrowDropDown, "contentDescription", tint = Color.Black)
//                    }
//                )
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false }
//                ) {
//                    sexos.forEachIndexed { index, sexo ->
//                        DropdownMenuItem(
//                            text = { Text(sexo) },
//                            onClick = {
//                                sexoSelecionadoState = index + 1
//                                expanded = false
//                            }
//                        )
//                    }
//                }
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                OutlinedTextField(
//                    value = senhaState,
//                    onValueChange = { senhaState = it },
//                    isError = erroLoginState,
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    label = { Text(text = "Senha") },
//                    shape = RoundedCornerShape(26.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Filled.Lock,
//                            contentDescription = "",
//                            tint = Color(0xFF2954C7)
//                        )
//                    })
//                Spacer(modifier = Modifier.height(10.dp))
//
//                OutlinedTextField(
//                    value = confirmarSenhaState,
//                    onValueChange = { confirmarSenhaState = it },
//                    isError = erroLoginState,
//                    modifier = Modifier
//                        .fillMaxWidth(), label = { Text(text = "Confirmar Senha") },
//                    shape = RoundedCornerShape(26.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Filled.Lock,
//                            contentDescription = "",
//                            tint = Color(0xFF2954C7)
//                        )
//                    }
//                )
//                Spacer(modifier = Modifier.height(20.dp))
//
//
//                // Botão FINALIZAR Cadastro
//                Button(
//                    onClick = {
//                        if (senhaState == confirmarSenhaState) {
//                            // As senhas coincidem, prosseguir com o cadastro
//                            val usuario = Usuario(
//                                nome = nomeState,
//                                email = emailState,
//                                cpf = cpfState,
//                                id_sexo = sexoSelecionadoState,
//                                senha = senhaState,
//                                data_nascimento = dataNascimentoState // Formate a data corretamente aqui
//                            )
//
//                            usuarioService.cadastrarUsuario(usuario)
//                                .enqueue(object : Callback<RespostaCadastro> {
//                                    override fun onResponse(
//                                        call: Call<RespostaCadastro>,
//                                        response: Response<RespostaCadastro>
//                                    ) {
//                                        if (response.isSuccessful) {
//                                            val resposta = response.body()
//                                            if (resposta != null && resposta.status == "success") {
//                                                // Cadastro bem-sucedido
//                                                Toast.makeText(
//                                                    context,
//                                                    resposta.mensagem,
//                                                    Toast.LENGTH_SHORT
//                                                ).show()
//                                                controleDeNavegacao.navigate("telaLogin") // Navega para a tela de login
//                                            } else {
//                                                // Tratar erro de cadastro (mensagem de erro da API)
//                                                val mensagemErro =
//                                                    resposta?.mensagem ?: "Erro desconhecido"
//                                                Toast.makeText(
//                                                    context,
//                                                    mensagemErro,
//                                                    Toast.LENGTH_SHORT
//                                                ).show()
//                                                Log.e("Cadastro", "Erro: $mensagemErro")
//                                            }
//                                        } else {
//                                            // Tratar erro de cadastro (código de status HTTP)
//                                            val mensagemErro =
//                                                "Erro ao cadastrar: ${response.code()}"
//                                            Toast.makeText(
//                                                context,
//                                                mensagemErro,
//                                                Toast.LENGTH_SHORT
//                                            ).show()
//                                            Log.e("Cadastro", "Erro: $mensagemErro")
//                                        }
//                                    }
//
//                                    override fun onFailure(
//                                        call: Call<RespostaCadastro>,
//                                        t: Throwable
//                                    ) {
//                                        // Tratar erro de conexão
//                                        val mensagemErro = "Erro de conexão: ${t.message}"
//                                        Toast.makeText(context, mensagemErro, Toast.LENGTH_SHORT)
//                                            .show()
//                                        Log.e("Cadastro", "Erro: $mensagemErro")
//                                    }
//                                })
//                        } else {
//                            // As senhas não coincidem, exibir erro
//                            Toast.makeText(context, "As senhas não coincidem.", Toast.LENGTH_SHORT)
//                                .show()
//                        }
//                    },
//                    modifier = Modifier
//                        .height(46.dp)
//                        .width(300.dp)
//                        .height(50.dp)
//                        .background(
//                            brush = Brush.horizontalGradient(
//                                colors = listOf(Color(0xFF77B8FF), Color(0xFF0133D6))
//                            ),
//                            shape = RoundedCornerShape(30.dp) // Define o formato do botão
//                        ),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color.Transparent // Para garantir que o gradiente seja visível
//                    ),
//                    contentPadding = PaddingValues() // Remove o padding padrão para o gradiente preencher todo o botão
//                ) {
//                    Text(
//                        text = "FINALIZAR",
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Black,
//                        color = Color.White
//                    )
//                }
//
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                // Links para login
//                Text(
//                    text = "Já possui conta?",
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Light
//                )
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Text(
//                    text = "Entre aqui",
//                    fontSize = 16.sp,
//                    color = Color(0xFF0436D7),
//                    fontWeight = FontWeight.Medium,
//                    modifier = Modifier.clickable {
//                        controleDeNavegacao.navigate("telaLogin")
//                    }
//                )
//
//                Spacer(modifier = Modifier.height(10.dp)) // Adiciona um espaçamento na parte inferior
//            }
//        }
//    }
//    }
//
