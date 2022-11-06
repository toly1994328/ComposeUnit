package com.toly1994.composeunit.widgets.LazyHorizontalGrid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import okhttp3.internal.toHexString

// "widgetId": 7,
// "name": "延迟横向网格基本使用",
// "subtitle":
//     【content】 : 内容  【LazyListScope.() -> Unit】
//     【reverseLayout】: 是否反序   【Boolean】
//     【rows】: 单元格配置   【GridCells】
//     【contentPadding】: 门边距   【PaddingValues】
//     【userScrollEnabled】: 是否允许滑动   【Boolean】
//     【horizontalArrangement】: 水平间距   【Arrangement.Horizontal】
//     【verticalArrangement】: 竖直间距   【Arrangement.Vertical】

@Composable
fun LazyHorizontalGridNode1() {
    val count = 64
    val step = 256 / count
    val colors = mutableListOf<Long>()
    for (index in 0..count) {
        colors.add(0xffff00ff - index * step)
    }
    LazyHorizontalGrid(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .height(230.dp),
        userScrollEnabled = true,
        reverseLayout = false,
        rows = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(colors.size) {
                index ->
            Box(
                modifier = Modifier
                    .background(Color(colors[index]))
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    text = "0x${colors[index].toHexString()}",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun LazyHorizontalGridPreview() {
    LazyHorizontalGridNode1()
}