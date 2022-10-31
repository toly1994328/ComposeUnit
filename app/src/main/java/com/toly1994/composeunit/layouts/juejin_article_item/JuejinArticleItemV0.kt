package com.toly1994.composeunit.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R


@Composable
fun JuejinArticleItemV0() {
    val titleTextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xff2F3032),
    )
    val contentTextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color(0xff5A576C),
    )
    val infoTextStyle = TextStyle(
        fontSize = 12.sp,
        color = Color(0xff86909c),
    )
    val typeTextStyle = TextStyle(
        fontSize = 12.sp,
        color = Color(0xff90959A),
        shadow = Shadow(
            color = Color.White,
            blurRadius = 2.0f,
            offset = Offset(1f, 1f)
        )
    )
    val userTextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color(0xff58575F),
    )
    val timeTextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color(0xff8C929E),
    )
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(20.dp, 10.dp)
    ) {
        Text(text = "【Flutter 异步编程 - 柒】 | 深入剖析 Stream 机制源码实现", style = titleTextStyle)
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(end = 5.dp)
            ) {
                Row(
                    Modifier.padding(0.dp, 4.dp)
                ) {
                    Text(text = "张风捷特烈", style = userTextStyle)
                    Text(text = "  |  ", style = timeTextStyle)
                    Text(text = "14小时前", style = timeTextStyle)
                }
                Text(
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    text = "一、从 Stream 的回调监听开始说起 在第三篇中，我们已经对 Stream 有了基本的概念认知，以及使用方式。 Stream 的特点是可以通过 listen 方法的第一入参 onData，不断监听",
                    style = contentTextStyle
                )
            }
            Image(
                modifier = Modifier
                    .width(90.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(10)),
                painter = painterResource(id = R.mipmap.caver),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(18.dp, 18.dp),
                tint = Color(0xff1F80FD),
                painter = painterResource(id = R.mipmap.zan), contentDescription = ""
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "100", style = infoTextStyle)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                modifier = Modifier.size(18.dp, 18.dp),
                tint = infoTextStyle.color,
                painter = painterResource(id = R.mipmap.pinglun), contentDescription = ""
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "99", style = infoTextStyle)
            Spacer(
                Modifier.weight(1f)
            )
            Wrapper(
                wrapperColor = Color(0xffF3F3F5),
                shape = RoundedCornerShape(10)
            ) {
                Text(text = "Android", style = typeTextStyle)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Wrapper(
                wrapperColor = Color(0xffF3F3F5),
                shape = RoundedCornerShape(10)
            ) {
                Text(text = "Flutter", style = typeTextStyle)
            }
        }
    }
}
