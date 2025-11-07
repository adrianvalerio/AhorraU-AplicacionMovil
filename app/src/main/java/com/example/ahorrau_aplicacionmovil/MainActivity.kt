package com.example.ahorrau_aplicacionmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.ahorrau_aplicacionmovil.ui.navigation.AppNavigation
import com.example.ahorrau_aplicacionmovil.ui.theme.AhorraUTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AhorraUTheme {
                AhorraUApp()
            }
        }
    }
}

@Composable
fun AhorraUApp() {
    val navController = rememberNavController()
    AppNavigation(navController = navController)
}
