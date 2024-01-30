package com.example.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.data.SampleData
import com.example.aluvery.model.Product
import com.example.aluvery.model.ProductTypesEnum
import com.example.aluvery.ui.components.headers.Header1

class ProductSectionProps(
    val sectionTitle: String,
    val modifier: Modifier = Modifier,
    val filter: ProductTypesEnum? = null,
    val isPromo: Boolean = false
)

@Composable
fun ProductSection(data: ProductSectionProps, products: List<Product>) {
    var productsList = products.filter { product -> product.type == data.filter }
    if (data.filter == null) productsList = SampleData.productsList
    if (data.isPromo) {
        productsList = products.filter { product -> product.inPromo }
    }

    Surface(data.modifier) {
        Column {
            Header1(
                text = data.sectionTitle,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            LazyRow(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(productsList) { product ->
                    ProductItem(product)
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ProductSectionPreview() {
    ProductSection(
        products = SampleData.productsList,
        data = ProductSectionProps(
            sectionTitle = "Salgados",
            filter = ProductTypesEnum.FOOD,
        )
    )
}