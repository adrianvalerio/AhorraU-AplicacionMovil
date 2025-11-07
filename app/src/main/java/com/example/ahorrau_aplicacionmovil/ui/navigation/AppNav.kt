package com.example.ahorrau_aplicacionmovil.ui.navigation

import CalculateView
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ahorrau_aplicacionmovil.ui.pages.*
import com.example.ahorrau_aplicacionmovil.ui.theme.AhorraUTheme

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginView(
                onLoginClick = { navController.navigate("home") },
                onRegisterClick = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegisterView(
                onBackClick = { navController.popBackStack() },
                onRegisterClick = { navController.navigate("home") }
            )
        }

        composable("home") {
            HomeView(
                onCalculateClick = { navController.navigate("calculate") }
            )
        }

        composable("calculate") {
            CalculateView(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    AhorraUTheme {
        val navController = rememberNavController()
        AppNavigation(navController = navController)
    }
}