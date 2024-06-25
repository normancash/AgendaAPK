package com.uam.agenda.compose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CustomTextField(name:String,psingleLine : Boolean = true,
                    pmaxLines:Int = 1, pLabel:String,
                    onNameChange : (String) -> Unit,modifier : Modifier = Modifier){

    TextField (
            value = name,
            onValueChange = onNameChange,
            modifier = modifier,
            label = {Text (text = pLabel)},
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                 focusedTextColor = Color.Blue,
                 unfocusedTextColor = Color.Gray
            ),
            singleLine = psingleLine,
            maxLines = pmaxLines
    )

}