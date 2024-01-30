package com.example.aluvery.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.aluvery.dao.ProductDao
import com.example.aluvery.model.Product

class AppState(
    val productDao: ProductDao
) {

    var allProducts = emptyList<Product>()
        get() = productDao.products()
        private set
    var searchText by mutableStateOf("")
        private set

    var filteredProducts = emptyList<Product>()
        get() {
            return allProducts.filter { it.title.contains(searchText, ignoreCase = true) }
        }
        private set

    val updateSearchText: (String) -> Unit = { searchText = it }

    val saveProduct: (Product) -> Unit = { productDao.save(it) }
}