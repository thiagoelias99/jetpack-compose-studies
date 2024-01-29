package com.example.aluvery.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.data.SampleData.Companion.productsList
import com.example.aluvery.ui.components.ProductItem
import com.example.aluvery.ui.components.headers.Header1
import com.example.aluvery.ui.theme.AluveryTheme

@Composable
fun AllProductsScreen() {
    val products = productsList

    Column(
        Modifier
            .padding(top = 16.dp)
    ) {
        Header1(text = "Todos os Produtos")
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            items(products) { product -> ProductItem(product) }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun AllProductsScreenPreview() {
    AluveryTheme {
        AllProductsScreen()
    }
}