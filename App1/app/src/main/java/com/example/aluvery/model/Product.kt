package com.example.aluvery.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.aluvery.R
import java.math.BigDecimal

class Product (
    var id: Int,
    var title: String,
    var price: BigDecimal,
    var description: String = "",
    @DrawableRes val image: Int = R.drawable.ic_launcher_background
){
    companion object {
        fun getMock(): Product {
            return Product(
                id = 1,
                title = LoremIpsum(words = 5).values.first(),
                price = BigDecimal(99.99),
                description = LoremIpsum(words = 15).values.first()
            )
        }
    }
}
