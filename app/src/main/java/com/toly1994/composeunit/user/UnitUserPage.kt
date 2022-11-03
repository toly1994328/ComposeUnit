package com.toly1994.composeunit.user

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.remember
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
import com.toly1994.composeunit.app.navigation.MenuItemData
import com.toly1994.composeunit.app.navigation.RouterRes
import com.toly1994.composeunit.doing.Doing

@Composable
fun UnitUserPage() {
    Column() {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        RouterRes.userMenuData.forEach(){
            UserMenuItem(it)
        }
    }
}

@Composable
fun UserMenuItem(data: MenuItemData){
    if(data.resImg == null){
        return Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
    }
    Row(
        Modifier.fillMaxWidth().height(50.dp)
            .background(Color.White).clickable(){},
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = data.resImg),
            "",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp).size(26.dp, 26.dp),
        )
        Text(data.text, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.mipmap.icon_left),
            "",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .size(18.dp, 18.dp))
    }
}

