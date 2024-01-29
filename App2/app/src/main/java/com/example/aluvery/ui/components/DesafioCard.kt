package com.example.aluvery.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.R
import com.example.aluvery.ui.theme.AluveryTheme
import com.example.aluvery.ui.theme.Purple500
import com.example.aluvery.ui.theme.Teal500

@Composable
fun DesafioCard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier
        ) {
        Row(
            Modifier
                .height(200.dp)
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple500,
                                Teal500
                            )
                        )
                    )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x = 50.dp)
                        .clip(shape = CircleShape)
                        .border(
                            BorderStroke(
                                2.dp,
                                brush = Brush.verticalGradient(listOf(Purple500, Color.Cyan))
                            ), CircleShape
                        )
                        .align(Alignment.Center),
                    contentDescription = "Product image"
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Box(
                Modifier
                    .padding(26.dp)
                    .fillMaxHeight()
                    .background(Color.White)
            ) {
                Text(
                    text = LoremIpsum(words = 50).values.first(),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun DesafioCardPreview() {
    AluveryTheme {
        DesafioCard()
    }
}