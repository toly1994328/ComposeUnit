package com.toly1994.composeunit.user

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R
import com.toly1994.composeunit.doing.Doing

@Composable
fun UnitUserPage() {

    Column() {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {

            Column {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.mipmap.base_draw),
                    contentDescription = "",
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.White),
                    contentAlignment = Alignment.CenterEnd

                ){
                    Text(
                        modifier = Modifier.offset(x=(-30).dp),
                        text = "张风捷特烈",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold)
                }
            }

            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .offset(40.dp, -10.dp)
                    .border(3.dp, Color.White, CircleShape)
                    .shadow(elevation = 1.dp, shape = CircleShape)
                ,
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.mipmap.icon_head),
                contentDescription = "",
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        UserMenuItem()
        UserMenuItem()
        UserMenuItem()

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        UserMenuItem()
        UserMenuItem()

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        UserMenuItem()

    }




}

@Composable
fun CircleRoundWrapperImage(
    modifier: Modifier
){

    Image(
        modifier = modifier
            .clip(CircleShape)
            .border(10.dp, Color.Red, CircleShape),
        painter = painterResource(id = R.mipmap.icon_head),
        contentDescription = "",
    )
}

@Composable
fun UserMenuItem(){
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
    ,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            Icons.Default.Warning, "",
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
        )
        Text("应用设置")
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            Icons.Default.ArrowForward, "",
            modifier = Modifier.padding(start = 15.dp, end = 15.dp).size(18.dp,18.dp))
    }
}

@Preview
@Composable
fun ComingSoonPreview() {
    UserMenuItem()
}
