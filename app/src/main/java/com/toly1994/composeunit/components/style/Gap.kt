package com.toly1994.composeunit.components.style



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Gap(width: Float = 0f, height: Float = 0f) {
    Spacer(modifier = Modifier
        .width(width.dp)
        .height(height.dp))
}