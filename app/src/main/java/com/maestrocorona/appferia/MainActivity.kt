package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.content.Intent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

//import nuevos agregados
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview

//se definen los colores para la AppFeria
private val Purple40 = Color(0xFF6650a4)
private val Purple80 = Color(0xFFD0BCFF)




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                // Iniciamos la segunda actividad cuando se presione el botón
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    // Pantalla principal que contiene todos los elementos
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Lista de negocios con sus imágenes
            BusinessItem("Negocios de la Nave 1")
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")
            BusinessItem("Atracciones y conciertos") // Aqui se añade la nueva card
            
            // Botón para navegar a la segunda actividad
            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes")
            }
        }
    }
}

@Composable
fun BusinessItem(text: String) {
    // Componente reutilizable para mostrar negocio con imagen
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp) ,
        shape = RoundedCornerShape(12.dp), // Esquinas redondeadas
        colors = CardDefaults.cardColors(
            containerColor = Purple40) // Color de fondo de la tarjeta
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del restaurante
            Image(
                painter = painterResource(id = R.drawable.logo_rest),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            // Texto del negocio
            Text(
                text = text,
                modifier = Modifier.padding(8.dp),
                //aqui se modifica el tipo de letra y el color
                fontFamily = FontFamily.SansSerif,
                fontSize =  18.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(onNavigateToSecondActivity = {})
}