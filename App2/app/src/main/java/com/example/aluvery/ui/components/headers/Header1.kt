package com.example.aluvery.ui.components.headers

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header1(text: String){
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        modifier = Modifier
            .padding(horizontal = 16.dp)
    )
}