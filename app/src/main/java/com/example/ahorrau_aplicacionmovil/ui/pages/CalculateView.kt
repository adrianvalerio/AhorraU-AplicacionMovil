package com.example.ahorrau_aplicacionmovil.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ahorrau_aplicacionmovil.ui.theme.GrayDark
import com.example.ahorrau_aplicacionmovil.ui.theme.White
import com.example.ahorrau_aplicacionmovil.ui.theme.YellowPrimary

@Composable
fun CalculateView(
    onBackClick: () -> Unit
) {
    var currentStep by remember { mutableStateOf(1) }
    var weeklySpending by remember { mutableStateOf("") }
    var savingGoal by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(YellowPrimary)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    "Regresar",
                    tint = GrayDark
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Regresar",
                fontWeight = FontWeight.Bold,
                color = GrayDark
            )
        }

        // Título principal
        Text(
            "Planifica tu ahorro",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = GrayDark,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            when (currentStep) {

                // Paso 1: Usuario ingresa su gasto semanal actual
                1 -> {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = White)
                    ) {
                        Column(
                            modifier = Modifier.padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "¿Cuánto gastas semanalmente?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = GrayDark,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            OutlinedTextField(
                                value = weeklySpending,
                                onValueChange = { weeklySpending = it },
                                placeholder = { Text("Ejemplo: 250") },
                                label = { Text("Gasto semanal (S/.)") },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = White,
                                    unfocusedContainerColor = White
                                ),
                                textStyle = LocalTextStyle.current.copy(
                                    textAlign = TextAlign.Center,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }

                // Paso 2: Usuario elige cuánto quiere ahorrar
                2 -> {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = White)
                    ) {
                        Column(
                            modifier = Modifier.padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "¿Cuánto quieres ahorrar esta semana?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = GrayDark,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            OutlinedTextField(
                                value = savingGoal,
                                onValueChange = { savingGoal = it },
                                placeholder = { Text("Ejemplo: 50") },
                                label = { Text("Ahorro deseado (S/.)") },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = White,
                                    unfocusedContainerColor = White
                                ),
                                textStyle = LocalTextStyle.current.copy(
                                    textAlign = TextAlign.Center,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }

                // Paso 3: Resultado
                3 -> {
                    val availableToSpend = weeklySpending.toFloatOrNull()?.minus(
                        savingGoal.toFloatOrNull() ?: 0f
                    ) ?: 0f

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = White)
                    ) {
                        Column(
                            modifier = Modifier.padding(40.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Tu resumen semanal",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Black,
                                color = GrayDark
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            Text(
                                "Gasto semanal: S/. $weeklySpending",
                                fontSize = 16.sp,
                                color = GrayDark
                            )
                            Text(
                                "Ahorro deseado: S/. $savingGoal",
                                fontSize = 16.sp,
                                color = GrayDark
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                "Podrás gastar hasta:",
                                fontSize = 16.sp,
                                color = GrayDark
                            )
                            Text(
                                "S/. %.2f".format(availableToSpend),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF4CAF50)
                            )

                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                "¡Ahorra inteligentemente esta semana!",
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                                color = GrayDark
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Botones inferiores
            if (currentStep < 3) {
                Button(
                    onClick = {
                        if ((currentStep == 1 && weeklySpending.isNotEmpty()) ||
                            (currentStep == 2 && savingGoal.isNotEmpty())
                        ) {
                            currentStep++
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GrayDark),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "Continuar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = White
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = GrayDark),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "Cancelar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            } else {
                Button(
                    onClick = onBackClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GrayDark),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "Volver al inicio",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatePreview() {
    CalculateView { }
}
