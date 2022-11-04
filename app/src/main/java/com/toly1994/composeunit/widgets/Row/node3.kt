package com.toly1994.composeunit.widgets.Row

import android.annotation.SuppressLint
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

// "widgetId": 4,
// "name": "行中的组件宽度占比",
// "subtitle":
//     Modifier 的 weight 属性只能用于 Row 和 Column 中，该案例里蓝色和绿色区域宽度占比 1:2，且无视盒自身宽度，使 Row 区域横向占满。
@SuppressLint("SuspiciousIndentation")
@Composable
fun RowNode3() {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Row(
        Modifier.width(250.dp).height(100.dp).background(Color(0xffEFEFEF)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[0]))
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[1]).weight(1f))
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[2]).weight(2f))
    }
}

@Preview
@Composable
fun RowNode3Preview() {
    RowNode3()
}