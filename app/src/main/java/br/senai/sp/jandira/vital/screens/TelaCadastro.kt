package br.senai.sp.jandira.vital.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.model.Usuario
import br.senai.sp.jandira.vital.service.RetrofitFactory
import br.senai.sp.jandira.vital.ui.theme.VitalTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(controleDeNavegacao: NavHostController) {
    val context = LocalContext.current
    val usuarioService = RetrofitFactory().getUserService()

    var nomeState by remember { mutableStateOf("") }
    var emailState by remember { mutableStateOf("") }
    var cpfState by remember { mutableStateOf("") }
    var sexoSelecionadoState by remember { mutableStateOf(0) }
    var senhaState by remember { mutableStateOf("") }
    var confirmarSenhaState by remember { mutableStateOf("") }
    var dataNascimentoState by remember { mutableStateOf("") }
    var erroLoginState by remember { mutableStateOf(false) }
    var mensagemErroState by remember { mutableStateOf("") }
    var isOverState by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val sexos = listOf("Masculino", "Feminino", "Outro")


//    Data de Nascimento
    var selectedDate by remember {
        mutableStateOf("")
    }

    val dateFormato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())


    VitalTheme {
        Column {
            Surface(
                modifier = Modifier
                    .height(250.dp)
                    .offset(y = -15.dp)

            ) {
                // Imagem da onda
                Image(
                    painter = painterResource(id = R.drawable.onda),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
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

            Column(
                modifier = Modifier
                    .padding(top = 0.dp, start = 26.dp, end = 26.dp, bottom = 26.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Criar Conta",
                    fontSize = 28.sp,
                    color = Color(0xFF2954C7)
                )

                OutlinedTextField(
                    value = nomeState,
                    onValueChange = { nomeState = it },
                    isError = erroLoginState,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth(),
                    label = { Text(text = "Nome") },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "",
                            tint = Color(0xFF2954C7)
                        )
                    }
                )

                OutlinedTextField(
                    value = emailState,
                    onValueChange = { emailState = it },
                    isError = erroLoginState,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "",
                            tint = Color(0xFF2954C7)
                        )
                    }
                )

                OutlinedTextField(value = cpfState,
                    onValueChange = { cpfState = it },
                    isError = erroLoginState,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "CPF") },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "",
                            tint = Color(0xFF2954C7)
                        )
                    }
                )

                OutlinedTextField(
                    value = selectedDate,
                    onValueChange = {
                       // Permitir a entrada de apenas numeros
                        text ->
                        val formattedText = formatoData(text)
                        if(formattedText.isNotEmpty()){
                            // Verifica se a data é valida
                            selectedDate = formattedText
                        }},
                    keyboardOptions = KeyboardOptions(
                        keyboardType =  KeyboardType.Number
                    ),
                    visualTransformation = DateVisualTransformation(),
                    isError = erroLoginState,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Data de Nascimento") },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.DateRange,
                            contentDescription = "",
                            tint = Color(0xFF2954C7)
                        )
                    }
                )

                // Dropdown para seleção de sexo
                OutlinedTextField(
                    value = if (sexoSelecionadoState == 0) "" else sexos[sexoSelecionadoState - 1],
                    onValueChange = { }, // Não é necessário onValueChange aqui
                    readOnly = true, // Torna o campo somente leitura
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true },
                    label = { Text(text = "Sexo") },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Face,
                            contentDescription = "",
                            tint = Color(0xFF2954C7)
                        )
                    },
                    trailingIcon = {
                        // Icon(Icons.Filled.ArrowDropDown, "contentDescription", tint = Color.Black)
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    sexos.forEachIndexed { index, sexo ->
                        DropdownMenuItem(
                            text = { Text(sexo) },
                            onClick = {
                                sexoSelecionadoState = index + 1
                                expanded = false
                            }
                        )
                    }
                }

                OutlinedTextField(
                    value = senhaState,
                    onValueChange = { senhaState = it },
                    isError = erroLoginState,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Senha") },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "",
                            tint = Color(0xFF2954C7)
                        )
                    })

                OutlinedTextField(
                    value = confirmarSenhaState,
                    onValueChange = { confirmarSenhaState = it },
                    isError = erroLoginState,
                    modifier = Modifier
                        .fillMaxWidth(), label = { Text(text = "Confirmar Senha") },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "",
                            tint = Color(0xFF2954C7)
                        )
                    }
                )

                // Links para login
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
                    modifier = Modifier.clickable {
                        controleDeNavegacao.navigate("telaLogin")
                    }
                )

                Spacer(modifier = Modifier.height(10.dp)) // Adiciona um espaçamento na parte inferior
            }
        }
    }


    }


// Visual da Data
class DateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val formattedText = formatoData(text.text)
        return TransformedText(AnnotatedString(formattedText), OffsetMapping.Identity)
    }
}
fun formatoData(text: String): String {
    val formattedDate = StringBuilder()
    var textWithoutSlash = text.replace("/", "")

    if (textWithoutSlash.length > 10){
        textWithoutSlash = textWithoutSlash.substring(0, 10)}

    for (i in textWithoutSlash.indices) {
        formattedDate.append(textWithoutSlash[i])
        if ((i == 1 || i == 4) && i < textWithoutSlash.length - 1) {
            formattedDate.append("/")
        }
    }

    // Limita o número de dígitos para cada parte da data
    val parts = formattedDate.toString().split("/")
    if (parts.size > 0 && parts[0].length > 2) {
        formattedDate.clear()
        formattedDate.append(parts[0].substring(0, 2))
        if (parts.size > 1) {
            formattedDate.append("/").append(parts[1])
            if (parts[1].length > 2) {
                formattedDate.replace(3, formattedDate.length, parts[1].substring(0, 2))
            }
            if (parts.size > 2) {
                formattedDate.append("/").append(parts[2])
                if (parts[2].length > 4) { // Quebra de linha adicionada aqui
                    formattedDate.replace(6, formattedDate.length, parts[2].substring(0, 4))
                }
            }}
    }

    return formattedDate.toString()
}