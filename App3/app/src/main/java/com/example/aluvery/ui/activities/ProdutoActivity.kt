package com.example.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aluvery.model.Product
import com.example.aluvery.states.AppStateManager
import com.example.aluvery.ui.screens.CreateProductScreen
import com.example.aluvery.ui.theme.AluveryTheme

//private val productDao = ProductDao()
private val appState = AppStateManager.getInstance()

class ProdutoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProductoActivityContent(
                saveFunction = { product ->
                    appState.saveProduct(product)
                    finish()
                }
            )
        }
    }
}

@Composable
fun ProductoActivityContent(
    saveFunction: (Product) -> Unit
) {
    AluveryTheme {
        Surface(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            CreateProductScreen(
                modifier = Modifier
                    .padding(16.dp),
                saveFunction = saveFunction
            )
        }
    }
}