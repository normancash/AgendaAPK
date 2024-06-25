package com.uam.agenda.compose

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.uam.agenda.R

@Composable
fun CustomPasswordField(name : String
                        ,onNameChange : (String) -> Unit
                        ,plabel : String
                        ,psingleLine : Boolean = true
                        ,pmaxLine : Int = 1){
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    val image = if (passwordVisible)
        painterResource(id = R.drawable.visibility)
    else
        painterResource(id = R.drawable.visibility_off)

    TextField(value=name,
        onValueChange = onNameChange
        ,label={
            Text(text= plabel)
        }
        , singleLine = psingleLine
        , maxLines = pmaxLine
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
}