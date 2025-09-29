package fr.univ.nantes.archi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.univ.nantes.core.ui.ArchiTPTheme
import fr.univ.nantes.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArchiTPTheme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        HomeScreen(
            name = "MIAGEs Nantes",
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArchiTPTheme {
        App()
    }
}