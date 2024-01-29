package com.example.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.aluvery.R
import com.example.aluvery.extensions.toBrazilianCurrency
import com.example.aluvery.model.Product
import com.example.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Surface(
        modifier
            .height(250.dp)
            .width(200.dp),
        color = Color.White,
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            Box(
                Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.image,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Product image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .offset(y = (50).dp)
                        .clip(shape = CircleShape)
                        .size(100.dp)
                        .background(color = Color.Red)
                        .align(Alignment.Center)
                )
                if (product.inPromo) {
                    Image(
                        painter = painterResource(id = R.drawable.promo),
                        contentDescription = "Product image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .offset(x = (-8).dp, y = (8).dp)
                            .clip(shape = CircleShape)
                            .size(36.dp)
                            .align(Alignment.TopEnd)
                    )
                }
            }
            Column(
                Modifier
                    .padding(top = 8.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = product.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    minLines = 2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            product.description?.let { description ->
                Text(
                    text = description,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .fillMaxWidth()

                )
            }
        }
    }
}

@Preview(
    showBackground = true,
//    showSystemUi = true
)
@Composable
fun ProductItemPreview() {
    AluveryTheme {
        Surface(Modifier.padding(16.dp)) {
            ProductItem(
                Product.getMock()
            )
        }
    }
}