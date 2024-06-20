package com.uam.agenda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.uam.agenda.compose.AgendaApp
import com.uam.agenda.ui.theme.AgendaTheme
import com.uam.agenda.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val loginViewModel by viewModels<LoginViewModel>()
        setContent {
            AgendaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //LoginApp(loginViewModel,Modifier.padding(innerPadding))
                    AgendaApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

