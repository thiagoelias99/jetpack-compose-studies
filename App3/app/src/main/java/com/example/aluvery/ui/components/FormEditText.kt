package com.example.aluvery.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.ui.theme.AluveryTheme

@Composable
fun FormEditText(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    errorMessage: String = ""
) {
    Column {
        OutlinedTextField(
            value,
            onValueChange,
            shape = RoundedCornerShape(25),
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            modifier = modifier
                .fillMaxWidth(),
            keyboardOptions = keyboardOptions,
            isError = errorMessage.isNotBlank()
        )
        if (errorMessage.isNotBlank()){
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun FormEditTextPreview() {
    AluveryTheme {
        Surface(
            Modifier
                .padding(vertical = 16.dp)
        ) {
            FormEditText(
                value = "",
                label = "Produto",
                placeholder = "Produto",
                onValueChange = {}
            )
        }
    }
}