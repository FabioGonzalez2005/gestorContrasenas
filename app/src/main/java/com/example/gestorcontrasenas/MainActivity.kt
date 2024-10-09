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
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
    var user by remember { mutableStateOf("Amaro_09") }
    var passwd by remember { mutableStateOf("elfutbolmola") }
    var isEditable by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }

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
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(250.dp))

                if (title.isNotEmpty()) {
                    Text(
                        text = title,
                        style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Usuario:",
                        style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    TextField(
                        value = user,
                        onValueChange = { user = it },
                        enabled = isEditable,
                        textStyle = TextStyle(fontSize = 24.sp),
                        modifier = Modifier.width(200.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Contraseña:",
                        style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    TextField(
                        value = passwd,
                        onValueChange = { passwd = it },
                        enabled = isEditable,
                        textStyle = TextStyle(fontSize = 24.sp),
                        modifier = Modifier.width(200.dp)
                    )
                }
            }

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
                        Text(text = "<", color = Color.White, style = TextStyle(fontSize = 25.sp))
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
                        Text(text = ">", color = Color.White, style = TextStyle(fontSize = 25.sp))
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            user = ""
                            passwd = ""
                            isEditable = true
                            title = "Añadir Usuario"
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00BF63)
                        )
                    ) {
                        Text(text = "Añadir", color = Color.White, style = TextStyle(fontSize = 25.sp))
                    }
                    Button(
                        onClick = {
                            user = ""
                            passwd = ""
                            isEditable = true
                            title = "Eliminar Usuario"
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00BF63)
                        )
                    ) {
                        Text(text = "Eliminar", color = Color.White, style = TextStyle(fontSize = 25.sp))
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
