package com.toly1994.composeunit.app.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun UnitSplash() {
    Column(
        Modifier
            .background(Color(0xffFAFAFA))
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        UnitSplashCenterLogo()
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.BottomCenter,
        ) {
            UnitSplashFooter(
                Modifier.offset(0.dp, (-15).dp)
            )
        }
    }
}

@Composable
fun UnitSplashCenterLogo() {
    Column(Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier.width(50.dp),
            painter = painterResource(id = R.mipmap.logo),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "ComposeUnit",
            style = TextStyle(
                fontSize = 20.sp,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = MaterialTheme.colors.secondary,
                    offset = Offset(.5f, .5f),
                    blurRadius = 2f
                )
            )
        )
    }
}

@Composable
fun UnitSplashFooter(
    modifier: Modifier
) {
    Column(modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val style = TextStyle(
            fontSize = 12.sp,
            color = Color.Gray,
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(.1f, .1f),
            )
        );
        Text(
            text = "Power By 张风捷特烈",
            style = style
        )
        Text(
            text = "· 2022 ·  @编程之王 ",
            style = style
        )
    }
}