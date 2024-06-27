package com.uam.agenda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.res.stringResource
import com.uam.agenda.screen.AgendaApp
import com.uam.agenda.ui.theme.AgendaTheme
import com.uam.agenda.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val loginViewModel by viewModels<LoginViewModel>()
        setContent {
            AgendaTheme {
                Scaffold(
                    topBar= {
                        TopAppBar(
                            title = { Text(text = stringResource(id = R.string.app_name)) }
                        )
                    },
                    contentWindowInsets = WindowInsets.statusBars
                ){paddingValues ->
                    AgendaApp(paddingValues)
                }
            }
        }
    }
}

