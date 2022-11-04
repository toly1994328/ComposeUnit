package com.toly1994.composeunit.widgets.Column

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// "widgetId": 5,
// "name": "列的水平对齐模式",
// "subtitle":
//     【horizontalAlignment】 : 水平对齐  【Alignment.Horizontal】
@SuppressLint("SuspiciousIndentation")
@Composable
fun ColumnNode2() {
    val data = mapOf(
        Alignment.Start to "Start",
        Alignment.CenterHorizontally to "CenterHorizontally",
        Alignment.End to "End",
    )
    val keys = data.keys.toList()
    val values = data.values.toList()
    Column {
        for (index in data.keys.indices step 3) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ColumnHAItem(keys[index], values[index])
                if (index+ 1 < data.size)
                ColumnHAItem(keys[index + 1], values[index + 1])
                if (index+ 2 < data.size)
                ColumnHAItem(keys[index + 2], values[index + 2])
            }
        }
    }
}

@Composable
fun ColumnHAItem(arrangement: Alignment.Horizontal, info: String) {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier.width(80.dp).height(120.dp).background(Color(0xffEFEFEF)),
            horizontalAlignment = arrangement,
        ) {
            colors.forEach {
                Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(it))
            }
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Preview
@Composable
fun ColumnNode2Preview() {
    ColumnNode2()
}