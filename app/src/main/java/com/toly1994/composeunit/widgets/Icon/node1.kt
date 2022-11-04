package com.toly1994.composeunit.widgets.Icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R

// "widgetId": 3,
// "name": "图标的使用",
// "subtitle":
//     【painter】 : 画板加载  【Painter】
//     【imageVector】: 矢量图片   【ImageVector】
//     【bitmap】: 位图加载   【ImageBitmap】
//     【tint】: 颜色   【Color】
//     【contentDescription】: 无障碍描述   【String?】

@Composable
fun IconNode1() {
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(id = R.mipmap.icon_code),
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.size(40.dp, 40.dp),
        )
        Icon(
            imageVector = Icons.Default.Lock,
            modifier = Modifier.width(50.dp).height(50.dp),
            tint = Color.Blue,
            contentDescription = null,
        )
        val imageBitmap = ImageBitmap.imageResource(R.mipmap.icon_kafi)
        Icon(
            bitmap = imageBitmap,
            tint = Color.Magenta,
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
    }
}


@Preview
@Composable
fun TextNode1Preview() {
    IconNode1()
}