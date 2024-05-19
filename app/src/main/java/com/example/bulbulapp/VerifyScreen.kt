package com.example.bulbulapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun VerifyScreen() {
    val phoneNumber = remember { mutableStateOf("081234567890") }
    val pinCode = remember { mutableStateOf("") }
    val otpCount = 4
    val isPinValid = remember { derivedStateOf { isValidPin(pinCode.value) } }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Verifikasi Akun",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Masukkan 4-digit kode PIN yang telah\ndikirimkan ke nomor ${phoneNumber.value}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            repeat(otpCount) { index ->
                CharView(index = index, text = pinCode.value)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        TextField(
            value = pinCode.value,
            onValueChange = { pinCode.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle pin verification */ },
            enabled = isPinValid.value,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verifikasi")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle resend pin code */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kirim ulang")
        }
    }
}

@Composable
fun CharView(index: Int, text: String) {
    Text(
        text = if (index < text.length) text[index].toString() else "_",
        style = MaterialTheme.typography.bodySmall
    )
}

private fun isValidPin(pinCode: String): Boolean {
    return pinCode.length == 4 && pinCode.all { it.isDigit() }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    VerifyScreen()
}
