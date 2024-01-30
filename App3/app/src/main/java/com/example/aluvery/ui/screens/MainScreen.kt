package com.example.aluvery.ui.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.dao.ProductDao
import com.example.aluvery.states.AppState
import com.example.aluvery.ui.components.DesafioCard
import com.example.aluvery.ui.components.ProductCard
import com.example.aluvery.ui.components.ProductSection
import com.example.aluvery.ui.components.ProductSectionProps
import com.example.aluvery.ui.components.Search
import com.example.aluvery.ui.theme.AluveryTheme

@Composable
fun MainScreen(
    appState: AppState
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Search(value = appState.searchText, onSearchTextChange = appState.updateSearchText)
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {

                if (appState.searchText.isBlank()) {
                    item {
                        ProductSection(
                            data = ProductSectionProps(
                                sectionTitle = "Promoções",
                                isPromo = true
                            ),
                            products = appState.allProducts
                        )
                    }
                    item {
                        DesafioCard(Modifier.padding(horizontal = 16.dp))
                    }
//                    item {
//                        ProductSection(
//                            ProductSectionProps(
//                                sectionTitle = "Salgados",
//                                filter = ProductTypesEnum.FOOD
//                            ),
//                            products = appState.allProducts
//                        )
//                    }
//                    item {
//                        ProductSection(
//                            ProductSectionProps(
//                                sectionTitle = "Doces",
//                                filter = ProductTypesEnum.SWEET
//                            ),
//                            products = appState.allProducts
//                        )
//                    }
//                    item {
//                        ProductSection(
//                            ProductSectionProps(
//                                sectionTitle = "Bebidas",
//                                filter = ProductTypesEnum.DRINK
//                            ),
//                            products = appState.allProducts
//                        )
//                    }
                } else {
                    items(appState.filteredProducts) { product ->
                        ProductCard(
                            product,
                            Modifier.padding(horizontal = 16.dp)
                        )
                    }
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
        MainScreen(
            appState = AppState(ProductDao())
        )
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
        MainScreen(
            appState = AppState(ProductDao())
        )
    }
}