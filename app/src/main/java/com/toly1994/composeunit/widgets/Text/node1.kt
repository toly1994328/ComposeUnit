package com.toly1994.composeunit.widgets.Text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// "widgetId": 1,
// "name": "文字的基本样式",
// "subtitle":
//     【text】 : 文字  【String】
//     【style】: 文字样式   【TextStyle】
//     【color】: 文字颜色   【Color】
//     【fontSize】: 文字大小   【TextUnit】
//     【fontWeight】: 字重   【FontWeight?】
//     【fontStyle】: 字体样式   【FontStyle?】
//     【letterSpacing】: 字距   【TextUnit】

@Composable
fun TextNode1() {
    val style = TextStyle(
        color = Color.Blue,
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        letterSpacing = 10.sp
    )
    Text(
        text = "toly-张风捷特烈-1994`",
        style = style,
    )
}

@Preview
@Composable
fun TextNode1Preview() {
    TextNode1()
}