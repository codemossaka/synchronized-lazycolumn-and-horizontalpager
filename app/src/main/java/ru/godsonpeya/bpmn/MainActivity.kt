package ru.godsonpeya.bpmn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ru.godsonpeya.bpmn.ui.theme.BPMNTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BPMNTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChantApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
