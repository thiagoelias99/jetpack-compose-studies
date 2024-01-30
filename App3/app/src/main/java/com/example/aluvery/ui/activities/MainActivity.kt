package com.example.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aluvery.states.AppStateManager
import com.example.aluvery.ui.screens.MainScreen
import com.example.aluvery.ui.theme.AluveryTheme

//private val productDao = ProductDao()
private val appState = AppStateManager.getInstance()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainActivityContent(
                fabAction = {
                    Intent(this, ProdutoActivity::class.java).run {
                        startActivity(this)
                    }
                }
            )
        }
    }
}

@Composable
fun MainActivityContent(
    fabAction: () -> Unit,
//    products: List<Product>
) {

//    var searchText by remember { mutableStateOf("") }
//
//    val mainScreenState = remember(products, searchText) {
//        MainScreenUiState(products)
//    }

//    val filteredProducts = if (searchText.isBlank()) {
//        emptyList<Product>()
//    } else {
//        products.filter { product -> product.title.contains(searchText, ignoreCase = true) }
//    }

//    val appState = remember() {
//        AppState(ProductDao())
//    }

    AluveryTheme {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = fabAction) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Button")
                }
            }
        )
        { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MainScreen(
                    appState
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun MainActivityPreview() {
    MainActivityContent(
        fabAction = {},
//        products = SampleData.productsList
    )
}

