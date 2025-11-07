package com.example.ahorrau_aplicacionmovil.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ahorrau_aplicacionmovil.ui.theme.GrayDark
import com.example.ahorrau_aplicacionmovil.ui.theme.White
import com.example.ahorrau_aplicacionmovil.ui.theme.YellowPrimary

@Composable
fun HomeView(
    onCalculateClick: () -> Unit
) {
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Menu, "Menú", tint = GrayDark)
            }

            Text(
                text = "Hola User218245!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = GrayDark
            )

            IconButton(onClick = { }) {
                Icon(Icons.Default.Notifications, "Notificaciones", tint = GrayDark)
            }
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            // Tarjeta Balance
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = White),
                elevation = CardDefaults.cardElevation(12.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text("Balance Total", fontSize = 12.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "S/. 2,450.00",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Black,
                        color = GrayDark
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Ingresos
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(Color(0xFFE8F5E9), RoundedCornerShape(12.dp))
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("↑ Ingresos", fontSize = 12.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    "S/. 3,000",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF4CAF50)
                                )
                            }
                        }

                        // Gastos
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(Color(0xFFFFEBEE), RoundedCornerShape(12.dp))
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("↓ Gastos", fontSize = 12.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    "S/. 550",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFF44336)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "¿Qué deseas hacer?",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = GrayDark
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botones de acción
            Button(
                onClick = onCalculateClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GrayDark),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Calcular mis gastos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GrayDark),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Gastos Totales",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GrayDark),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Detalle de mis Gastos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Progreso de ahorro
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = White),
                elevation = CardDefaults.cardElevation(12.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(
                        "Progreso de Ahorro",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Meta: S/. 5,000", fontSize = 14.sp)
                        Text("49%", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    LinearProgressIndicator(
                        progress = 0.49f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp),
                        color = YellowPrimary,
                        trackColor = Color.LightGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "¡Ahorrar es progreso!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = GrayDark,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeView { }
}
