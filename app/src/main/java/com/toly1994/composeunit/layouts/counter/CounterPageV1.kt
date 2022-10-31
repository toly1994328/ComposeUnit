package com.toly1994.composeunit.layouts.counter


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

// 计数器: V1 版
// 拆分组件，明确结构

@Composable
fun CounterPageV1(title: String) {
    val count: MutableState<Int> = remember { mutableStateOf(0) }
    Scaffold(
        topBar = { HomeTopBar(title) },
        floatingActionButton = {
            HomeFab(onClick = { count.value++ })
        })
    { HomeContent(count.value) }
}

// 对于比较简单的构建逻辑
// 单独抽离组件就会显得多此一举
@Composable
fun HomeTopBar(title: String) {
    TopAppBar(
        title = { Text(title) },
    )
}

@Composable
fun HomeFab(onClick: () -> Unit) {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        content = {
            Icon(Icons.Rounded.Add, "")
        },
        onClick = onClick
    )
}

@Composable
fun HomeContent(count: Int) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have pushed the button this many times:")
        Text(
            text = "$count", style = TextStyle(
                fontSize = 36.sp,
                color = Color.Gray
            )
        )
    }
}