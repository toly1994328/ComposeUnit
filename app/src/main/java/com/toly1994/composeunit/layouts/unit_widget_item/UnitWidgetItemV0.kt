package com.toly1994.composeunit.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun UnitWidgetItem() {
    val titleTextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xff2F3032),
    )

    val contentTextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color(0xff2F3032),
    )

    val infoTextStyle = TextStyle(
        fontSize = 12.sp,
        color = Color(0xff86909c),
    )

    val starTextStyle = TextStyle(
        color = MaterialTheme.colors.primary,
    )

    val typeTextStyle = TextStyle(
        fontSize = 10.sp,
        shadow = Shadow(
            color = Color.White,
            blurRadius = 2.0f,
            offset = Offset(1f, 1f)
        )
    )

    val collectTextStyle = TextStyle(
        fontSize = 10.sp,
        color = MaterialTheme.colors.primary,
        shadow = Shadow(
            color = Color.White,
            blurRadius = 2.0f,
            offset = Offset(1f, 1f)
        )
    )

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(20.dp, 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Text", style = titleTextStyle)
            Spacer(modifier = Modifier.width(6.dp))
            Wrapper(wrapperColor = Color(0xffF3F3F5)) {
                Text(text = "已收藏", style = collectTextStyle)
            }

//            Box(
//                Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.CenterEnd
//            ) {
//                Text(text = "★★★★★★", style = starTextStyle)
//            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "★★★★★★", style = starTextStyle)

        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "用于显示文字的组件。拥有的属性非常多，足够满足你的使用需求,核心样式由style属性控制。", style = contentTextStyle)
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(
                Modifier
                    .width(4.dp)
                    .height(4.dp)
                    .clip(CircleShape)
                    .background(infoTextStyle.color)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "文字组件", style = infoTextStyle)
            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Wrapper(
                    wrapperColor = Color(0xffF3F3F5),
                    shape = RoundedCornerShape(10)
                ) {
                    Text(text = "展示型", style = typeTextStyle)
                }
            }

        }
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
            .background(wrapperColor)) {
        Box(Modifier.padding(8.dp, 4.dp))
        { content() }
    }
}