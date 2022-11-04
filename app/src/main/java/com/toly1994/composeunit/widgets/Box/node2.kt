package com.toly1994.composeunit.widgets.Box

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

// "widgetId": 6,
// "name": "列的竖直对齐模式",
// "subtitle":
//     【verticalArrangement】 : 竖直对齐模式  【Arrangement.Vertical】
//     【content】: 内容组件列表   【@Composable RowScope.() -> Unit】

@SuppressLint("SuspiciousIndentation")
@Composable
fun BoxNode2() {
    val colors = arrayOf(Color.Red, Color.Yellow , Color.Blue, Color.Green)
    Box(
        Modifier.width(250.dp).height(100.dp).background(Color(0xffEFEFEF)),
        contentAlignment = Alignment.CenterEnd
    ) {
        Spacer(modifier = Modifier.width(60.dp).height(60.dp).background(colors[3]))
        Spacer(modifier = Modifier.width(50.dp).height(50.dp).background(colors[2]))
        Spacer(modifier = Modifier.width(40.dp).height(40.dp).background(colors[1]))
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[0]).align(Alignment.BottomStart))
    }
}

@Preview
@Composable
fun BoxNode2Preview() {
    BoxNode2()
}