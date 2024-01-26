package com.example.aluvery.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.model.ProductTypesEnum
import com.example.aluvery.ui.components.DesafioCard
import com.example.aluvery.ui.components.ProductSection
import com.example.aluvery.ui.components.ProductSectionProps

@Composable
fun MainScreen(){
    Surface(
        color = Color.Transparent,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            ProductSection(
                ProductSectionProps(
                    sectionTitle = "Promoções",
                    isPromo = true
                )
            )
            Box(
                Modifier.padding(horizontal = 16.dp)
            ) {
                DesafioCard()
            }
            ProductSection(
                ProductSectionProps(
                    sectionTitle = "Salgados",
                    filter = ProductTypesEnum.FOOD
                )
            )
            ProductSection(
                ProductSectionProps(
                    sectionTitle = "Doces",
                    filter = ProductTypesEnum.SWEET
                )
            )
            ProductSection(
                ProductSectionProps(
                    sectionTitle = "Bebidas",
                    filter = ProductTypesEnum.DRINK
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainScreenPreview() {
    MainScreen()
}