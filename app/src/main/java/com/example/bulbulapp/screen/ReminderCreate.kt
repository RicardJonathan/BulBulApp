package com.example.bulbulapp.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReminderScreen()
        }
    }
}

@Composable
fun ReminderScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pengingat") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            var selectedCategory by remember { mutableStateOf("") }
            var date by remember { mutableStateOf("") }
            var time by remember { mutableStateOf("") }
            var repeatOption by remember { mutableStateOf("Kali ini saja") }
            var note by remember { mutableStateOf("") }
            var selectedDays by remember { mutableStateOf(setOf<String>()) }

            // Category dropdown
            var expanded by remember { mutableStateOf(false) }
            val items = listOf("Makan", "Bermain", "Grooming", "Vaksin", "Lainnya")

            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = selectedCategory,
                    onValueChange = { selectedCategory = it },
                    label = { Text("Aktivitas") },
                    placeholder = { Text("Pilih Aktivitas") },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                            Modifier.clickable { expanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth(),
                    properties = PopupProperties(focusable = true)
                ) {
                    items.forEach { item ->
                        DropdownMenuItem(onClick = {
                            selectedCategory = item
                            expanded = false
                        }) {
                            Text(text = item)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Date and Time Row
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    label = { Text("Tanggal") },
                    placeholder = { Text("MM / DD / YYYY") },
                    trailingIcon = {
                        Icon(Icons.Filled.CalendarToday, contentDescription = "Select Date")
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                OutlinedTextField(
                    value = time,
                    onValueChange = { time = it },
                    label = { Text("Waktu") },
                    placeholder = { Text("00:00") },
                    trailingIcon = {
                        Icon(Icons.Filled.Schedule, contentDescription = "Select Time")
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Repeat options
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = repeatOption == "Ulangi",
                    onClick = { repeatOption = "Ulangi" }
                )
                Text("Ulangi")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = repeatOption == "Kali ini saja",
                    onClick = { repeatOption = "Kali ini saja" }
                )
                Text("Kali ini saja")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Days of the week selection
            val daysOfWeek = listOf("Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Min")
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                daysOfWeek.forEach { day ->
                    val isSelected = selectedDays.contains(day)
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                if (isSelected) Color(0xFFFF8066) else Color(0xFFE0E0E0),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable(enabled = repeatOption == "Ulangi") {
                                selectedDays = if (isSelected) {
                                    selectedDays - day
                                } else {
                                    selectedDays + day
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(day, color = if (isSelected) Color.White else Color.Black)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Notes input
            OutlinedTextField(
                value = note,
                onValueChange = { note = it },
                label = { Text("Catatan") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Submit button
            Button(
                onClick = { /* Handle save */ },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF8066)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Tambahkan", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReminderScreenPreview() {
    ReminderScreen()
}
