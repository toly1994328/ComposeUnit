package com.toly1994.composeunit.widgets.Text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// "widgetId": 1,
// "name": "文字装饰线与缩进",
// "subtitle":
//     【textDecoration】 : 文字装饰  【TextDecoration】
//     【textIndent】: 文字缩进   【textIndent】

@Composable
fun TextNode3() {
    val style1 = TextStyle(
        fontSize = 25.sp,
        textDecoration = TextDecoration.LineThrough
    )
    val style2 = TextStyle(
        fontSize = 25.sp,
        textIndent = TextIndent(20.sp),
        textDecoration = TextDecoration.Underline
    )
    Row{
        Text(
            text = "张风捷特烈",
            style = style1,
        )
        Text(
            text = "张风捷特烈",
            style = style2,
        )
    }
}

@Preview
@Composable
fun TextNode3Preview() {
    TextNode3()
}
