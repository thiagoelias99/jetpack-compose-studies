package com.example.aluvery.model

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import java.math.BigDecimal

class Product (
    var id: Int,
    var title: String,
    var price: BigDecimal,
    var description: String? = null,
    var type: ProductTypesEnum,
    val image: String? = null,
    var inPromo: Boolean = false
){
    companion object {
        fun getMock(): Product {
            return Product(
                id = 1,
                title = LoremIpsum(words = 5).values.first(),
                price = BigDecimal(99.99),
                description = LoremIpsum(words = 15).values.first(),
                type = ProductTypesEnum.FOOD,
                inPromo = true
            )
        }
    }
}

enum class ProductTypesEnum {
    FOOD, DRINK, SWEET
}
