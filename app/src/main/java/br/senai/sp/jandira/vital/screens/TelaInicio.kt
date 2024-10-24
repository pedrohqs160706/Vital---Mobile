package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.model.NavItem

@Composable
fun TelaInicio(modifier: NavHostController){

//    Criar a lista de Itens
    val navItemList = listOf(
        NavItem("Ínicio", Icons.Default.Home),
        NavItem("Favoritos", Icons.Default.Star),
        NavItem("Carrinho", Icons.Default.ShoppingCart),
        NavItem("Notificações", Icons.Default.Notifications)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick =
                        {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon" )
                        },
                        label = {
                            Text(text = navItem.label)
                        }

                    )
                }
            }
        }
    ){ innerPadding ->
        ContentScreen(
            modifier = Modifier
            .padding(innerPadding)
        )
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier) {
    
}