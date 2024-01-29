package com.example.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.aluvery.R
import com.example.aluvery.data.SampleData.Companion.productsList
import com.example.aluvery.extensions.toBrazilianCurrency
import com.example.aluvery.model.Product
import com.example.aluvery.ui.theme.AluveryTheme


@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                expanded = !expanded
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        )
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.FillBounds
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.inversePrimary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.title
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            product.description?.let {description ->
                Text(
                    text = description,
                    maxLines = if (expanded) Int.MAX_VALUE else 3,
                    overflow = if (expanded) TextOverflow.Visible else TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    AluveryTheme {
        Surface {
            ProductCard(
                product = productsList.random(),
            )
        }
    }
}