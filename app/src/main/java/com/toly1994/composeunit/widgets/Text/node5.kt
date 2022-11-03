package com.toly1994.composeunit.widgets.Text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// "widgetId": 1,
// "name": "文字对齐与行高",
// "subtitle":
//     【textAlign】: 文字对齐   【TextAlign?】
//     【lineHeight】 : 行高  【TextUnit】


@Composable
fun TextNode5() {
    val data = arrayOf(
        TextAlign.Start,
        TextAlign.Center,
        TextAlign.End,
        TextAlign.Justify,
        TextAlign.Right,
        TextAlign.Left,
    )

    Column {
        for (index in data.indices step 2) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextAlignItem(data[index])
                TextAlignItem(data[index + 1])
            }
        }
    }
}

@Composable
fun TextAlignItem(align: TextAlign) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.width(150.dp).height(90.dp)
                .padding(bottom = 3.dp).background(Color(0xffEFEFEF))
        ) {
            Text(
                text = "ComposeUnit is an application for learn Compose.",
                textAlign = align,
                lineHeight = 20.sp
            )
        }
        Text(text = "TextAlign.$align", color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Preview
@Composable
fun TextNode5Preview() {
    TextNode5()
}
