package com.example.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.R
import com.example.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection() {
    val products = listOf<Product>(
        Product(id = 1, title = "Hamburguer", price = BigDecimal(19.99), description = "Um hambúrguer é um sanduíche composto por um ou mais hambúrgueres de carne, vegetais e condimentos entre pães.", image = R.drawable.burger),
        Product(id = 2, title = "Pizza", price = BigDecimal(44.99), description = "Uma pizza é um prato de massa de formato redondo, coberto com molho de tomate e uma variedade de ingredientes, como queijo, vegetais, carnes e ervas, assada em forno.", image = R.drawable.pizza),
        Product(id = 3, title = "Batata Frita", price = BigDecimal(8.99), image = R.drawable.fries)
    )

    Surface {
        Column {
            Text(
                text = "Produtos",
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                products.map { product -> ProductItem(product) }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ProductSectionPreview() {
    ProductSection()
}