package com.example.bulbulapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun NavigationBarItem(
    item: NavigationItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier // Removed redundant .padding(8.dp) here
            .clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = item.iconResourceId),
            contentDescription = item.title,
            tint = if (selected) {
                Color.Blue
            } else {
                Color.Gray
            }
        )
        Spacer(modifier = Modifier.width(8.dp)) // This line uses width modifier
        Text(
            text = item.title,
            style = MaterialTheme.typography.body2,
            color = if (selected) {
                Color.Blue
            } else {
                Color.Gray
            }
        )
    }
}