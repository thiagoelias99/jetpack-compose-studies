package com.example.aluvery.states

import com.example.aluvery.dao.ProductDao

object AppStateManager {
    private var instance: AppState? = null
    private val productDao = ProductDao()

    fun getInstance(): AppState {
        return instance ?: synchronized(this) {
            instance ?: buildAppState().also { instance = it }
        }
    }

    private fun buildAppState(): AppState {
        return AppState(this.productDao)
    }
}
