package com.toly1994.composeunit.widgets.Text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// "widgetId": 1,
// "name": "多行与包裹溢出",
// "subtitle":
//     【softWrap】 : 是否自动换行  【Boolean】
//     【overflow】: 溢出方式   【TextOverflow】
//     【maxLines】: 最大行数   【Int】

@Composable
fun TextNode4() {
    Text(
        modifier = Modifier
            .width(200.dp)
            .background(Color(0xffEFEFEF))
            .padding(10.dp),
        text = "ComposeUnit is an application for learn Compose.",
        fontSize = 16.sp,
        softWrap = true,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
    )
}

@Preview
@Composable
fun TextNode4Preview() {
    TextNode4()
}
