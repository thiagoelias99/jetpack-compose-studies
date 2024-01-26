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
import com.example.aluvery.data.SampleData
import com.example.aluvery.model.Product
import com.example.aluvery.model.ProductTypesEnum
import java.math.BigDecimal

class ProductSectionProps (
    val sectionTitle: String,
    val filter: ProductTypesEnum? = null,
    val isPromo: Boolean = false
)
@Composable
fun ProductSection(data: ProductSectionProps) {
    var products = SampleData.productsList.filter { product -> product.type == data.filter }
    if (data.filter == null) products = SampleData.productsList
    if (data.isPromo){products = SampleData.productsList.filter { product -> product.inPromo }}

    Surface {
        Column {
            Text(
                text = data.sectionTitle,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
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
    ProductSection(
        ProductSectionProps(
            sectionTitle = "Salgados",
            filter = ProductTypesEnum.FOOD
        )
    )
}