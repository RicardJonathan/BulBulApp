package com.example.bulbulapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bulbulapp.ui.theme.BulBulAppTheme

class CreateMyPet : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BulBulAppTheme {
                CreateMyPetScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateMyPetScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create My Pet") },
            )
        }
    ) {
        CreateMyPetContent()
    }
}

@Composable
fun CreateMyPetContent() {
    var name by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf("Dog") }
    var selectedSize by remember { mutableStateOf("Small") }
    var selectedBodyCondition by remember { mutableStateOf(5) }
    var selectedActivityLevel by remember { mutableStateOf(2) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Pet type selection
        Row(verticalAlignment = Alignment.CenterVertically) {
            PetTypeButton(
                imageVector = ImageVector.vectorResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = "Dog",
                isSelected = selectedType == "Dog",
                onClick = { selectedType = "Dog" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            PetTypeButton(
                imageVector = ImageVector.vectorResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = "Cat",
                isSelected = selectedType == "Cat",
                onClick = { selectedType = "Cat" }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Pet photo upload
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(ImageVector.vectorResource(id = android.R.drawable.ic_menu_add), contentDescription = "Add Photo")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add Photo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Name input
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Gender selection
        GenderSelection(selectedGender, onGenderSelected = { selectedGender = it })

        Spacer(modifier = Modifier.height(16.dp))

        // Weight input
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Age input
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Size selection
        Text("Body Size")
        SizeSelection(selectedSize, onSizeSelected = { selectedSize = it })

        Spacer(modifier = Modifier.height(16.dp))

        // Body condition slider
        Text("Body Condition")
        Slider(
            value = selectedBodyCondition.toFloat(),
            onValueChange = { selectedBodyCondition = it.toInt() },
            valueRange = 1f..9f,
            steps = 7,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Activity level slider
        Text("Activity Level")
        Slider(
            value = selectedActivityLevel.toFloat(),
            onValueChange = { selectedActivityLevel = it.toInt() },
            valueRange = 1f..3f,
            steps = 1,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit button
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Done")
        }
    }
}

@Composable
fun PetTypeButton(
    imageVector: ImageVector,
    contentDescription: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                shape = CircleShape
            )
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Icon(imageVector, contentDescription)
    }
}

@Composable
fun GenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selectedGender == "Female",
            onClick = { onGenderSelected("Female") }
        )
        Text("Female")
        Spacer(modifier = Modifier.width(16.dp))
        RadioButton(
            selected = selectedGender == "Male",
            onClick = { onGenderSelected("Male") }
        )
        Text("Male")
    }
}

@Composable
fun SizeSelection(selectedSize: String, onSizeSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        listOf("Toy", "Small", "Medium", "Large", "Giant").forEach { size ->
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (selectedSize == size) MaterialTheme.colorScheme.primary else Color.Gray,
                        shape = CircleShape
                    )
                    .padding(8.dp)
                    .clickable { onSizeSelected(size) }
            ) {
                Text(text = size, modifier = Modifier.align(Alignment.Center))
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateMyPetScreenPreview() {
    BulBulAppTheme {
        CreateMyPetScreen()
    }
}
