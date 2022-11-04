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
// "name": "图片缩放模式",
// "subtitle":
//     【contentScale】 : 缩放模式  【ContentScale】

@SuppressLint("SuspiciousIndentation")
@Composable
fun ImageNode3() {
    val data = mapOf(
        ContentScale.Fit to "Fit",
        ContentScale.Crop to "Crop",
        ContentScale.FillHeight to "FillHeight",
        ContentScale.FillWidth to "FillWidth",
        ContentScale.FillBounds to "FillBounds",
        ContentScale.None to "None",
        ContentScale.Inside to "Inside",
    )
    val keys = data.keys.toList();
    val values = data.values.toList();
    Column {
        for (index in data.keys.indices step 2) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageContentScaleItem(keys[index],values[index])
                if(index<data.size-1)
                ImageContentScaleItem(keys[index+1],values[index+1])
            }
        }
    }
}

@Composable
fun ImageContentScaleItem(contentScale: ContentScale,info: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.width(150.dp).height(90.dp)
                .padding(bottom = 3.dp).background(Color(0xffEFEFEF))
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo),
                modifier = Modifier.width(150.dp).height(90.dp),
                contentScale = contentScale,
                contentDescription = null,
            )
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Preview
@Composable
fun ImageNode3Preview() {
    ImageNode3()
}