package com.toly1994.composeunit.widgets.Column

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

// "widgetId": 5,
// "name": "列的竖直对齐模式",
// "subtitle":
//     【verticalArrangement】 : 竖直对齐模式  【Arrangement.Vertical】
//     【content】: 内容组件列表   【@Composable RowScope.() -> Unit】

@SuppressLint("SuspiciousIndentation")
@Composable
fun ColumnNode1() {
    val data = mapOf(
        Arrangement.Top to "Center",
        Arrangement.SpaceBetween to "SpaceBetween",
        Arrangement.SpaceAround to "SpaceAround",
        Arrangement.SpaceEvenly to "SpaceEvenly",
        Arrangement.Bottom to "End",
        Arrangement.Center to "Start",
    )
    val keys = data.keys.toList();
    val values = data.values.toList();
    Column {
        for (index in data.keys.indices step 3) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ColumnVAItem(keys[index],values[index])
                if(index+1<data.size)
                ColumnVAItem(keys[index+1],values[index+1])
                if(index+2<data.size)
                ColumnVAItem(keys[index+2],values[index+2])
            }
        }
    }
}
@Composable
fun ColumnVAItem(arrangement: Arrangement.Vertical, info: String) {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier.width(80.dp).height(150.dp).background(Color(0xffEFEFEF)),
            verticalArrangement = arrangement
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
fun ColumnNode1Preview() {
    ColumnNode1()
}