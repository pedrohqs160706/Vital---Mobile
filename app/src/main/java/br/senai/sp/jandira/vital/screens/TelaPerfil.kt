package br.senai.sp.jandira.vital.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.model.Usuario
import br.senai.sp.jandira.vital.model.UsuarioResponse
import br.senai.sp.jandira.vital.service.RetrofitFactory
import br.senai.sp.jandira.vital.ui.theme.VitalTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TelaPerfil(controleDeNavegacao: NavHostController, idUsuario: Int ) {

    // Criando variaveis de estado
    var user by remember {
        mutableStateOf<Usuario?>(null)
    }

    var id by remember {
        mutableStateOf("")
    }

    // Requisicao da API
    LaunchedEffect(key1 = idUsuario) {
        val callUsuario = RetrofitFactory()
            .getUsuarioService()
            .getUsuarioById(idUsuario)

        callUsuario.enqueue(object : Callback<UsuarioResponse> {
            override fun onResponse(call: Call<UsuarioResponse>, response: Response<UsuarioResponse>) {
                if (response.isSuccessful) {
                    val usuario = response.body()?.usuario

                    // Log para garantir que a lista de usuários não está null
                    Log.i("USUARIO_RESPONSE", "Lista de usuários: $usuario")

                    if (usuario != null && usuario.isNotEmpty()) {
                        user = usuario[0]
                        Log.i("USUARIO", "Usuário carregado: ${user!!.nome}")
                    } else {
                        Log.e("USUARIO_ERROR", "Nenhum usuário encontrado ou a lista está vazia.")
                    }
                } else {
                    Log.e("USUARIO_ERROR", "Erro ao carregar usuário: ${response.code()}")
                }
            }


            override fun onFailure(call: Call<UsuarioResponse>, t: Throwable) {
                Log.e("USUARIO_ERROR", "Falha ao buscar usuário: ${t.message}")
            }
        })

    }
   VitalTheme {
       Surface {
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

               AsyncImage(
                   model = user?.foto,
                   contentDescription = "Foto do usuário",
                   modifier = Modifier
                       .width(80.dp)
                       .height(80.dp)
                       .clip(RoundedCornerShape(40.dp)) // Aplica bordas arredondadas
                       .align(Alignment.TopEnd) // Posiciona no canto superior direito
                       .clickable {
                           controleDeNavegacao.navigate("telaPerfil") // Substitua pelo nome da rota
                       },
                   contentScale = ContentScale.Crop
               )

           }
       }
   }
}