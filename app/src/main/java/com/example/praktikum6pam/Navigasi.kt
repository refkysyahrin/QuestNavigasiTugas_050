package com.example.praktikum6pam

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6pam.view.Dashboard
import java.lang.reflect.Modifier

enum class Navigasi{
    Dashboard,
    Daftar,
    Formulir
}

@Composable
fun DataApp(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Navigasi.Dashboard.name,
        modifier = Modifier.padding()
    ){
        composable(route = Navigasi.Dashboard.name) {
            Dashboard(
                //Tombol di dashboard bisa langsung navigasi ke daftar
                onNavigate = {
                    navController.navigate(Navigasi.Daftar.name)
                }
            )
        }

        
    }
}

