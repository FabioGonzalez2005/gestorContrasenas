package com.example.gestorcontrasenas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import android.content.Context
import android.util.Log
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comprobarYCrearArchivo("usersAndPass.txt")

        setContent {
            MainContent()
        }
    }

    private fun comprobarYCrearArchivo(nombreArchivo: String) {
        val directorio = filesDir
        val archivo = File(directorio, nombreArchivo)

        if (!archivo.exists()) {
            try {
                val crear = archivo.createNewFile()
                if (crear) {
                    archivo.writeText("Amaro_09:elfutbolmola\nUser1:password1\nUser2:password2")
                    Log.i("DAM2", "Archivo creado correctamente.")
                }
            } catch (e: Exception) {
                Log.i("DAM2", "Error al crear el archivo")
            }
        } else {
            Log.i("DAM2", "El archivo ya existe.")
        }
    }

    private fun cargarDatos(context: Context, nombreArchivo: String): List<Pair<String, String>> {
        val archivo = File(context.filesDir, nombreArchivo)
        val listaUsuarios = mutableListOf<Pair<String, String>>()

        if (archivo.exists()) {
            val lineas = archivo.readLines()
            for (linea in lineas) {
                val partes = linea.split(":")
                if (partes.size == 2) {
                    listaUsuarios.add(partes[0] to partes[1])
                }
            }
        }
        return listaUsuarios
    }

    @Composable
    fun MainContent() {
        val context = LocalContext.current
        var userPass by remember { mutableStateOf(listOf<Pair<String, String>>()) }
        var indiceArchivo by remember { mutableStateOf(0) }
        var editable by remember { mutableStateOf(false) }
        var user by remember { mutableStateOf("") }
        var passwd by remember { mutableStateOf("") }
        var title by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            userPass = cargarDatos(context, "usersAndPass.txt")
        }

        val userActual = if (userPass.isNotEmpty()) {
            userPass[indiceArchivo].first
        } else ""

        val passActual = if (userPass.isNotEmpty()) {
            userPass[indiceArchivo].second
        } else ""

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
                    style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color.White),
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
                            value = if (editable) user else userActual,
                            onValueChange = { user = it },
                            enabled = editable,
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
                            value = if (editable) passwd else passActual,
                            onValueChange = { passwd = it },
                            enabled = editable,
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
                            onClick = {
                                if (indiceArchivo > 0) {
                                    indiceArchivo -= 1
                                    user = userPass[indiceArchivo].first
                                    passwd = userPass[indiceArchivo].second
                                }
                            },
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
                            onClick = {
                                if (indiceArchivo < userPass.size - 1) {
                                    indiceArchivo += 1
                                    user = userPass[indiceArchivo].first
                                    passwd = userPass[indiceArchivo].second
                                }
                            },
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
                                editable = true
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
                                editable = true
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
}
