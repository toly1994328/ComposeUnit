package com.toly1994.composeunit.app.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.toly1994.composeunit.R

@Composable
fun UnitAppBar(route:String?){
    when(route){
      UnitRoute.user -> UnitUserAppBar()
        else ->  TopAppBar(
            title = { Text("ComposeUnit") },
        )
    }

}


@Composable
fun UnitUserAppBar(){

}
