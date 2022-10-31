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
import com.toly1994.composeunit.models.WidgetModel



@Composable
fun UnitWidgetItemV1(
    modifier: Modifier = Modifier,
    model: WidgetModel) {
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
    var starText = "";
    for (i in 0 until model.lever) {
        starText+="★"
    }

    Column(
        modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(20.dp, 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = model.name, style = titleTextStyle)
            Spacer(modifier = Modifier.width(6.dp))
            if(model.collectd){
                Wrapper(wrapperColor = Color(0xffF3F3F5)) {
                    Text(text = "已收藏", style = collectTextStyle)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = starText, style = starTextStyle)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = model.info, style = contentTextStyle)
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
            Text(text = model.nameCN, style = infoTextStyle)
            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Wrapper(
                    wrapperColor = Color(0xffF3F3F5),
                    shape = RoundedCornerShape(10)
                ) {
                    Text(text = model.family, style = typeTextStyle)
                }
            }

        }
    }
}
