package com.toly1994.composeunit.widgets.Image

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R

// "widgetId": 2,
// "name": "图片对齐模式",
// "subtitle":
//     【alignment】 : 对齐模式  【Alignment】

@SuppressLint("SuspiciousIndentation")
@Composable
fun ImageNode2() {
    val data = mapOf(
        Alignment.Center to "Center",
        Alignment.CenterStart to "CenterStart",
        Alignment.CenterEnd to "CenterEnd",
        Alignment.TopCenter to "TopCenter",
        Alignment.BottomCenter to "BottomCenter",
        Alignment.BottomStart to "BottomStart",
        Alignment.BottomEnd to "BottomEnd",
        Alignment.TopStart to "TopStart",
        Alignment.TopEnd to "TopEnd",

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
                ImageAlignmentItem(keys[index],values[index])
                if(index+1<data.size)
                ImageAlignmentItem(keys[index+1],values[index+1])
                if(index+2<data.size)
                ImageAlignmentItem(keys[index+2],values[index+2])
            }
        }
    }
}

@Composable
fun ImageAlignmentItem(alignment: Alignment ,info: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.width(80.dp).height(50.dp)
                .padding(bottom = 3.dp).background(Color(0xffEFEFEF))
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo_mini),
                modifier = Modifier.width(80.dp).height(50.dp),
                alignment = alignment,
                contentScale = ContentScale.None,
                contentDescription = null,
            )
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Preview
@Composable
fun ImageNode2Preview() {
    ImageNode2()
}