package com.example.aluvery.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.data.SampleData.Companion.productsList
import com.example.aluvery.model.Product
import com.example.aluvery.model.ProductTypesEnum
import com.example.aluvery.ui.components.DesafioCard
import com.example.aluvery.ui.components.ProductCard
import com.example.aluvery.ui.components.ProductSection
import com.example.aluvery.ui.components.ProductSectionProps
import com.example.aluvery.ui.components.Search
import com.example.aluvery.ui.theme.AluveryTheme

@Composable
fun MainScreen() {
    var text by remember { mutableStateOf("") }
    val products = productsList
    val filteredProducts = remember(text){
        //so atualiza se text mudar, melhora performance
        if (text.isBlank()) {
            emptyList<Product>()
        } else {
            productsList.filter { product -> product.title.contains(text, ignoreCase = true) }
        }
    }

    Surface(
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Search(value = text, onSearchTextChange = {newText -> text = newText})
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {

                if(text.isBlank()){
                    item {
                        ProductSection(
                            ProductSectionProps(
                                sectionTitle = "Promoções",
                                isPromo = true
                            )
                        )
                    }
                    item {
                            DesafioCard(Modifier.padding(horizontal = 16.dp))
                    }
                    item {
                        ProductSection(
                            ProductSectionProps(
                                sectionTitle = "Salgados",
                                filter = ProductTypesEnum.FOOD
                            )
                        )
                    }
                    item {
                        ProductSection(
                            ProductSectionProps(
                                sectionTitle = "Doces",
                                filter = ProductTypesEnum.SWEET
                            )
                        )
                    }
                    item {
                        ProductSection(
                            ProductSectionProps(
                                sectionTitle = "Bebidas",
                                filter = ProductTypesEnum.DRINK
                            )
                        )
                    }
                } else {
                    items(filteredProducts){product -> ProductCard(product, Modifier.padding(horizontal = 16.dp))}
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun MainScreenPreview() {
    AluveryTheme {
        MainScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MainScreenPreviewDark() {
    AluveryTheme {
        MainScreen()
    }
}