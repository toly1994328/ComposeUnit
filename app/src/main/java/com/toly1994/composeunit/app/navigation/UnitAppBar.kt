package com.toly1994.composeunit.app.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R

@Composable
fun UnitAppBar(route:String?){
    when(route){
      UnitRoute.user -> UserPageAppBar()
        else ->  TopAppBar(
            title = { Text("ComposeUnit") },
        )
    }

}


@Composable
fun UserPageAppBar(){
    Box(contentAlignment = Alignment.BottomStart) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth().height(180.dp),
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
                .offset(40.dp, (-10).dp)
                .border(3.dp, Color.White, CircleShape)
                .shadow(elevation = 1.dp, shape = CircleShape),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.mipmap.icon_head),
            contentDescription = "",
        )
    }
}