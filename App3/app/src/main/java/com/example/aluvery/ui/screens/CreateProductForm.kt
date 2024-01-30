package com.example.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.aluvery.R
import com.example.aluvery.model.Product
import com.example.aluvery.model.ProductTypesEnum
import com.example.aluvery.ui.components.FormEditText
import com.example.aluvery.ui.components.headers.Header1
import java.math.BigDecimal

val TAG = "CreateProductForm"

@Composable
fun CreateProductScreen(
    modifier: Modifier = Modifier,
    saveFunction: (Product) -> Unit = {}
) {
    var url by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Header1(
            text = "Criar produto"
        )
        if (url.isNotBlank()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }

        FormEditText(
            value = url,
            label = "Url",
            placeholder = "Insira a Url da imagem",
            onValueChange = { newValue -> url = newValue },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )
        FormEditText(
            value = name,
            label = "Nome",
            placeholder = "Insira o nome do produto",
            onValueChange = { newValue -> name = newValue },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        fun validarNumeroDecimal(texto: String): Boolean {
            val regex = Regex("^-?\\d*([.,])?\\d+\$")
            return regex.matches(texto)
        }

        fun normalizarNumeroDecimal(texto: String): BigDecimal {
            try {
                return BigDecimal(texto.replace(",", "."))
            } catch (error: java.lang.NumberFormatException) {
                throw error
            }
        }

        FormEditText(
            value = price,
            label = "Preço",
            onValueChange = { newValue -> price = newValue },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            errorMessage = if (validarNumeroDecimal(price) || price.isBlank()) "" else "Preço deve ser um valor decimal"
        )

        FormEditText(
            value = description,
            label = "Descrição",
            placeholder = "Insira a descrição do produto",
            onValueChange = { newValue -> description = newValue },
            modifier = Modifier
                .heightIn(min = 160.dp)
        )
        Button(
            onClick = {
                val normalizedPrice = try {
                    normalizarNumeroDecimal(price)
                } catch (e: NumberFormatException) {
                    BigDecimal(0)
                }

                saveFunction(
                    Product(
                        title = name,
                        id = 15,
                        price = normalizedPrice,
                        image = url,
                        type = ProductTypesEnum.FOOD,
                        inPromo = true
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun CreateProductScreenPreview() {
    CreateProductScreen()
}