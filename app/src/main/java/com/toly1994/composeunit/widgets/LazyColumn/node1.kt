package com.toly1994.composeunit.widgets.LazyColumn

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.layouts.UnitWidgetItemV1
import okhttp3.internal.toHexString

// "widgetId": 7,
// "name": "延迟纵向列表基本使用",
// "subtitle":
//     【content】 : 内容  【LazyListScope.() -> Unit】
//     【reverseLayout】: 是否反序   【Boolean】
//     【contentPadding】: 门边距   【PaddingValues】
//     【userScrollEnabled】: 是否允许滑动   【Boolean】
//     【horizontalAlignment】: 水平对齐方式   【Alignment.Horizontal】
//     【verticalArrangement】: 竖直对齐方式   【Arrangement.Vertical】

@Composable
fun LazyColumnNode1() {
    val count = 20
    val step = 256 / count
    val colors = mutableListOf<Long>()
    for (index in 0..count) {
        colors.add(0xffff00ff - index * step)
    }
    LazyColumn(
        modifier = Modifier.padding(horizontal = 20.dp).height(230.dp),
        userScrollEnabled = true,
        reverseLayout = false
    ) {
        itemsIndexed(colors) { _, value ->
            Box(modifier = Modifier
                .background(Color(value))
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
                ){
                Text(
                    modifier = Modifier.padding(vertical = 15.dp),
                    text = "0x${value.toHexString()}",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun LazyColumnNode1Preview() {
    LazyColumnNode1()
}