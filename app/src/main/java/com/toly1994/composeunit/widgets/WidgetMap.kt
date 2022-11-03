package com.toly1994.composeunit.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.toly1994.composeunit.widgets.Text.*

@Composable
fun WidgetNodeMap(widgetId: Int, index: Int) {
    if (widgetId == 1 && index == 0) Playground{ TextNode1()}
    if (widgetId == 1 && index == 1) Center{TextNode2()}
    if (widgetId == 1 && index == 2) Center{TextNode3()}
    if (widgetId == 1 && index == 3) Center{TextNode4()}
    if (widgetId == 1 && index == 4) Center{TextNode5()}
}

@Composable
fun Playground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            Modifier
                .width(200.dp)
                .height((0.618 * 0.618 * 200).dp),
            color = Color(0xffEFEFEF)
        ) {
            content()
        }
    }
}

@Composable
fun Center(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}