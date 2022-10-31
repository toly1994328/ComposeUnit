package com.toly1994.composeunit.layouts.wechat_item

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R

@Composable
fun WeChatItem(banned:Boolean = false) {
    val titleTextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xff2F3032),
    )

    val subTextStyle = TextStyle(
        fontSize = 12.sp,
        color = Color(0xffC5C5C5),
    )

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier.padding(10.dp, 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    contentAlignment = BiasAlignment(1.2f, -1.2f)
                ) {
                    Image(
                        modifier = Modifier
                            .width(45.dp)
                            .clip(RoundedCornerShape(10)),
                        painter = painterResource(id = R.mipmap.head_icon),
                        contentDescription = "",
                    )
                    if(banned) {
                        Spacer(
                            Modifier
                                .width(10.dp)
                                .height(10.dp)
                                .clip(CircleShape)
                                .background(Color.Red)
                        )
                    } else {
                        CircleNumTip(
                            color = Color.Red, radius = 8f, count = 1
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(text = "堕天使者", style = titleTextStyle)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "你好，Compose 学的怎么样了？", style = subTextStyle)
                }
                Column() {
                    Text(text = "22:25", style = subTextStyle)
                    if(banned) {
                        Spacer(modifier = Modifier.height(6.dp))
                    }
                    if(banned) {
                        Icon(
                            Icons.Default.Warning, "",
                            tint = subTextStyle.color,
                            modifier = Modifier.size(18.dp,18.dp))
                    }
                }
            }
        }
        Divider(
            startIndent = 70.dp,
            thickness = 0.5.dp
        )
    }


}

@Composable
fun Wrapper(
    wrapperColor: Color,
    shape: RoundedCornerShape = CircleShape,
    content: @Composable () -> Unit
) {
    Box(
        Modifier
            .clip(shape)
            .background(wrapperColor)
    ) {
        Box(Modifier.padding(8.dp, 4.dp))
        { content() }
    }
}

@Composable
fun CircleNumTip(
    color: Color,
    count: Int,
    radius: Float,
) {
    Box(
        Modifier
            .width(radius.dp * 2)
            .height(radius.dp * 2)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$count", style = TextStyle(
                fontSize = (radius / 0.8).sp,
                color = Color.White,
            )
        )
    }
}