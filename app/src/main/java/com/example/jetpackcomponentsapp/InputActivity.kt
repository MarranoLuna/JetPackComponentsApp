package com.example.jetpackcomponentsapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomponentsapp.ui.theme.JetpackComponentsAppTheme

    class InputActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                JetpackComponentsAppTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        ComponentesInput()
                    }
                }
            }
        }
    }

    @Composable
    fun ComponentesInput() {
        var text by remember { mutableStateOf("") }
        var outlineText by remember { mutableStateOf("") }
        var checked by remember { mutableStateOf(false) }
        var switchOn by remember { mutableStateOf(false) }
        var sliderValue by remember { mutableStateOf(0f) }
        var selectedOption by remember { mutableStateOf("A") }

        val opciones = listOf("A", "B", "C")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("TextField simple") }
            )

            OutlinedTextField(
                value = outlineText,
                onValueChange = { outlineText = it },
                label = { Text("OutlinedTextField") }
            )

            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(checked = checked, onCheckedChange = { checked = it })
                Text("Checkbox")
            }

            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Switch(checked = switchOn, onCheckedChange = { switchOn = it })
                Text("Switch")
            }

            Text("Slider: ${sliderValue.toInt()}")
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..100f
            )

            Text("RadioButtons:")
            opciones.forEach { option ->
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                    Text("Opción $option")
                }
            }
        }
    }


@Preview(showBackground = true, name = "Vista previa de ComponentesInput")
@Composable
fun ComponentesInputPreview() {
    JetpackComponentsAppTheme {
        ComponentesInput()
    }
}