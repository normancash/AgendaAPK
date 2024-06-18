package com.uam.agenda.compose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.uam.agenda.R
import com.uam.agenda.viewmodel.LoginViewModel

@Composable
fun LoginApp(loginViewModel: LoginViewModel, innerPadding: Modifier) {
    val localContext = LocalContext.current

    val state = loginViewModel._state

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    val image = if (passwordVisible)
                    painterResource(id = R.drawable.visibility)
                else
                    painterResource(id = R.drawable.visibility_off)

    LaunchedEffect(key1 = state.message)
    {
        if (!state.message.isNullOrBlank()) {
            Toast.makeText(localContext, state.message, Toast.LENGTH_LONG).show()
            loginViewModel.restartState()
        }
    }



    Column(modifier=Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center){
       Image(painter = painterResource(id = R.drawable.usuario)
           , contentDescription = null)
       Spacer(modifier = Modifier.height(5.dp))
       TextField(value=state.email,
           onValueChange = {loginViewModel.onEmail(it)}
           ,label={
           Text(text= stringResource(id = R.string.email))})
        Spacer(modifier = Modifier.height(5.dp))
        TextField(value=state.password,
            onValueChange = {loginViewModel.onPassword(it)}
            ,label={
                Text(text= stringResource(id = R.string.password))}
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            , trailingIcon = {
                val descripcion = if (passwordVisible) "Password oculto" else "Mostrar Password"
                IconButton(onClick = {passwordVisible = !passwordVisible }) {
                     Icon(painter= image,descripcion)
                }
            }
            , visualTransformation = if (passwordVisible) VisualTransformation.None
                                     else PasswordVisualTransformation()

        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {loginViewModel.onLogin()}) {
            Text(text=stringResource(id=R.string.botonLogin))
        }
    }
}