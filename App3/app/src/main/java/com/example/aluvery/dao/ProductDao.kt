package com.example.aluvery.dao

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.example.aluvery.model.Product

class ProductDao{
    companion object {
        //mutableStateListOf notifica os Composables da mudança
//        private val products = mutableStateListOf<Product>(*productsList.toTypedArray())
        private val products = mutableStateListOf<Product>()
    }
    fun products() = products.toList()

    fun save(product: Product) {
        Log.i("TAG", "save: $product")
        products.add(product)
    }
}