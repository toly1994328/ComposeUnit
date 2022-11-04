package com.toly1994.composeunit.widgets.Image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R

// "widgetId": 2,
// "name": "图片加载方式",
// "subtitle":
//     【painter】 : 画板加载  【Painter】
//     【imageVector】: 矢量图片   【ImageVector】
//     【bitmap】: 位图加载   【ImageBitmap】
//     【alpha】: 透明度   【Float】
//     【contentDescription】: 无障碍描述   【String?】

@Composable
fun ImageNode1() {
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.mipmap.logo),
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
        Image(
            imageVector = Icons.Default.Lock,
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
        val imageBitmap = ImageBitmap.imageResource(R.mipmap.icon_head)
        Image(
            bitmap = imageBitmap,
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
        Image(
            painter = painterResource(id = R.mipmap.logo),
            modifier = Modifier.width(60.dp).height(60.dp),
            alpha = 0.5f,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun ImageNode1Preview() {
    ImageNode1()
}