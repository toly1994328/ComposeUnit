package com.toly1994.composeunit.widgets.Column

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R
import com.toly1994.composeunit.widgets.Image.ImageContentScaleItem

// "widgetId": 5,
// "name": "列中的组件高度占比",
// "subtitle":
//     Modifier 的 weight 属性只能用于 Row 和 Column 中，该案例里蓝色和绿色区域高度占比 1:2，且无视盒自身高度，使 Column 区域竖向占满。

@Composable
fun ColumnNode3() {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Column(
        Modifier.width(250.dp).height(100.dp).background(Color(0xffEFEFEF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.width(30.dp).height(30.dp).background(colors[0]))
        Spacer(Modifier.width(30.dp).height(30.dp).background(colors[1]).weight(1f))
        Spacer(Modifier.width(30.dp).height(30.dp).background(colors[2]).weight(2f))
    }
}

@Preview
@Composable
fun ColumnNode3Preview() {
    ColumnNode3()
}