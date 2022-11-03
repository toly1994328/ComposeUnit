package com.toly1994.composeunit.widgets.Text

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// "widgetId": 1,
// "name": "文字背景与阴影",
// "subtitle":
//     【backgroundColor】 : 背景颜色  【Color】
//     【shadow】: 阴影   【Shadow】

@Composable
fun TextNode2() {
    val style = TextStyle(
        color = Color.White,
        fontSize = 50.sp,
        background = Color.Black,
        shadow = Shadow(
            color = Color.Cyan,
            offset = Offset(1f,1f),
            blurRadius = 10f
        )
    )
    Text(
        text = "张风捷特烈",
        style = style,
        modifier = Modifier.clip(RectangleShape)
    )
}

@Preview
@Composable
fun TextNode2Preview() {
    TextNode2()
}
