package com.example.aluvery.ui.components.headers

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Header1(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        modifier = modifier
    )
}

@Preview(
    showBackground = true
)
@Composable
fun Header1Preview() {
    Header1(text = "Header 1")
}