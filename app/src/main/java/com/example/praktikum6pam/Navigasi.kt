package com.example.praktikum6pam


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6pam.view.DaftarPeserta
import com.example.praktikum6pam.view.Pendaftaran
import com.example.praktikum6pam.view.Dashboard

enum class Navigasi{
    Dashboard,
    Daftar,
    Formulir
}

@Composable
fun DataApp(
    modifier: Modifier = Modifier,

    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Navigasi.Dashboard.name,

        modifier = modifier
    ){
        composable(route = Navigasi.Dashboard.name) {
            Dashboard(
                //Tombol di dashboard bisa langsung navigasi ke daftar
                onNavigate = {
                    navController.navigate(Navigasi.Daftar.name)
                }
            )
        }

        composable(route = Navigasi.Daftar.name) {
            DaftarPeserta(
                onBeranda = {
                    navController.popBackStack(Navigasi.Dashboard.name, inclusive = false)
                },
                onForm = {
                    navController.navigate(Navigasi.Formulir.name)
                }
            )
        }

        composable(route = Navigasi.Formulir.name) {
            Pendaftaran(
                onBeranda = {
                    cancelAndBackToDaftar(navController)
                }
            )
        }
    }
}

private fun cancelAndBackToDaftar(
    navController: NavHostController
){
    navController.popBackStack(Navigasi.Daftar.name, inclusive = false)
}