package com.toly1994.composeunit.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun WidgetDetail(
    widgetId:Int?,
    widgetName:String?,
    back: () -> Unit) {
    Column {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = back) {
                    Icon(
                        Icons.Default.ArrowBack, "",
                    )
                }
            },
            title = {
                Text(text = "组件详情页")
            }
        )
        Column(
            Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "组件id: ${widgetId}", fontSize = 20.sp)
            Text(text = "组件名: ${widgetName}", fontSize = 20.sp)

        }
    }
}