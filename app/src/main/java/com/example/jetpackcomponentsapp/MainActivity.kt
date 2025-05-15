package com.example.jetpackcomponentsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomponentsapp.ui.theme.JetpackComponentsAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComponentsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComponentesBasicos(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComponentesBasicos(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola Jetpack Compose!", style = MaterialTheme.typography.titleLarge)

        Button(onClick = { /* Acción */ }) {
            Text("Botón de ejemplo")
        }

        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Image",
            modifier = Modifier.size(100.dp)
        )

        Divider(color = Color.Gray, thickness = 1.dp)  //línea gris de separación

        Row(  //acomoda los elementos en horizontal.
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Fila:")
            Text("Item 1")
            Text("Item 2")
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Caja")
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true, name = "Componentes Básicos")
@Composable
fun ComponentesBasicosPreview() {
    JetpackComponentsAppTheme {
        ComponentesBasicos()
    }
}