import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    var weeklyBudget by remember { mutableStateOf("120") }
    var spendAmount by remember { mutableStateOf("") }

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

        // Título
        Text(
            "Calcular mis gastos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = GrayDark,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Contenido según el paso
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (currentStep) {
                1 -> {
                    // Paso 1: Mostrar gasto semanal
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
                                "Tu gasto semanal",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = GrayDark
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                "S/. $weeklyBudget",
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Black,
                                color = GrayDark
                            )
                        }
                    }
                }

                2 -> {
                    // Paso 2: Ingresar cuánto gastar
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
                                "Tu gasto semanal",
                                fontSize = 14.sp,
                                color = GrayDark
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "S/. $weeklyBudget",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = GrayDark
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            Text(
                                "Cuánto quieres gastar (S/.)",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = GrayDark
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            OutlinedTextField(
                                value = spendAmount,
                                onValueChange = { spendAmount = it },
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

                3 -> {
                    // Paso 3: Confirmación
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
                                "¡Listo!",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Black,
                                color = GrayDark
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                "Se te notificará un recordatorio cuando llegues al 80% de tu gasto total",
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                                color = GrayDark
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Botones
            if (currentStep < 3) {
                Button(
                    onClick = { currentStep++ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GrayDark),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "Confirmar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = GrayDark
                    ),
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
                        "Volver al Inicio",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CalculatePreview(){
    CalculateView { }
}