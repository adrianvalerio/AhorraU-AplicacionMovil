package com.example.ahorrau_aplicacionmovil.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.ahorrau_aplicacionmovil.ui.theme.GrayDark
import com.example.ahorrau_aplicacionmovil.ui.theme.White
import com.example.ahorrau_aplicacionmovil.ui.theme.YellowPrimary

@Composable
fun LoginView(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(YellowPrimary)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "AhorraU",
            fontSize = 48.sp,
            fontWeight = FontWeight.Black,
            color = GrayDark
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Bienvenido",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = GrayDark
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "Cómo deseas iniciar sesión",
            fontSize = 14.sp,
            color = GrayDark
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = White),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Inicia con Gmail",
                color = GrayDark,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1877F2)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Inicia con Facebook",
                color = White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .width(200.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GrayDark),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Ingresar",
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "¿No tienes cuenta? Regístrate",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = GrayDark,
            modifier = Modifier.clickable { onRegisterClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginView (onLoginClick = {}, onRegisterClick = {})
}
