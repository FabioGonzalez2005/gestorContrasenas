package com.example.gestorcontrasenas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF00BF63))
                .padding(vertical = 34.dp)
        ) {
            Text(
                text = "Gestor de contraseñas",
                style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Usuario:",
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Contraseña:",
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(150.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00BF63)
                        )
                    ) {
                        Text(text = "Añadir", color = Color.White)
                    }
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00BF63)
                        )
                    ) {
                        Text(text = "Eliminar", color = Color.White)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00BF63)
                        )
                    ) {
                        Text(text = "Ver", color = Color.White)
                    }
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00BF63)
                        )
                    ) {
                        Text(text = "Editar", color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    MainContent()
}
