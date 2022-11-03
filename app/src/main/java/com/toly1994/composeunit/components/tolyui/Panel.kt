package com.toly1994.composeunit.components.tolyui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Panel(
    radius: Float = 5.0f,
    color: Color = Color(0xffF6F8FA),
    content: @Composable () -> Unit,
) {
    Surface(
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(radius.dp))
    ) {
        Box(modifier = Modifier.padding(10.dp)
        ) { content() }
    }
}