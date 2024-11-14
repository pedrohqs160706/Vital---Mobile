package br.senai.sp.jandira.vital

import Agendamento
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.vital.screens.InfoMedico
import br.senai.sp.jandira.vital.screens.TelaAdicionarCartao
import br.senai.sp.jandira.vital.screens.TelaAlterarSenha
import br.senai.sp.jandira.vital.screens.TelaCadastro
//import br.senai.sp.jandira.vital.screens.TelaCadastro
import br.senai.sp.jandira.vital.screens.TelaHome
import br.senai.sp.jandira.vital.screens.TelaInicial1
import br.senai.sp.jandira.vital.screens.TelaInicial2
import br.senai.sp.jandira.vital.screens.TelaInicial3
import br.senai.sp.jandira.vital.screens.TelaInicio
import br.senai.sp.jandira.vital.screens.TelaLogin
import br.senai.sp.jandira.vital.screens.TelaMedicos
import br.senai.sp.jandira.vital.screens.TelaTelemedicina
import br.senai.sp.jandira.vital.ui.theme.VitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VitalTheme {
                // Vai lembrar da navegacao que esta fazendo para depois voltar
                val controleDeNavegacao = rememberNavController()

                // Chamar uma funcao NavHost
                NavHost(
                    navController = controleDeNavegacao,
                    // Quando eu abrir a aplicacao qual a tela que vai aparecer
                    startDestination = "telaMedicos" // essa palavra login é criada, mas esta referente a tela que queremos
                ) {
                    // Todas as telas tem que ficar aqui
                    composable(route = "telaInicial1") { TelaInicial1(controleDeNavegacao) }
                    composable(route = "telaInicial") { TelaInicio(controleDeNavegacao) }
                    composable(route = "telaInicial2") { TelaInicial2(controleDeNavegacao) }
                    composable(route = "telaInicial3") { TelaInicial3(controleDeNavegacao) }
                    composable(route = "telaLogin") { TelaLogin(controleDeNavegacao) }
                    composable(route = "telaCadastro") { TelaCadastro(controleDeNavegacao) }
                    composable(route = "telaInicio") { TelaInicio(controleDeNavegacao) }
                    composable(route = "telaHome") { TelaHome(controleDeNavegacao) }

                    // Agendamento
                    composable(route = "telaAgendamento") { Agendamento(controleDeNavegacao) }



                    // Medicos
                    composable(route = "telaInfoMedico") { InfoMedico(controleDeNavegacao) }
                    composable(route = "telaMedicos") { TelaMedicos(controleDeNavegacao) }


                    // Navegacao da Lazy Row - Tela Home
                    composable(route = "telaTelemedicina") { TelaTelemedicina(controleDeNavegacao) }




                    composable(route = "telaAlterarSenha") { TelaAlterarSenha(controleDeNavegacao) }
//                    composable(route = "telaCadastro") { TelaCadastro(controleDeNavegacao) }
                    composable(route = "telaAdicionarCartao") { TelaAdicionarCartao() }
//                    composable("telaHome/{nome}") { backStackEntry ->
//                        val nomeUsuario = backStackEntry.arguments?.getString("nome")
//                        TelaHome()


                }
            }
        }
    }


}
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        VitalTheme {
            Greeting("Android")
        }
    }