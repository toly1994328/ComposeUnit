package com.toly1994.composeunit.home


import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.toly1994.composeunit.layouts.UnitWidgetItemV1
import com.toly1994.composeunit.models.WidgetModel

@Composable
fun LayoutHomePage(title: String) {
    val text = WidgetModel(
        id = 2,
        name = "Text",
        nameCN = "文字组件",
        lever = 5,
        family = "无内容组件",
        collectd = true,
        info = "用于显示文字的组件。拥有的属性非常多，足够满足你的使用需求,核心样式由style属性控制。"
    )

    val column = WidgetModel(
        id = 2,
        name = "Column",
        nameCN = "列布局组件",
        lever = 4,
        family = "多内容组件",
        collectd = false,
        info = "排布方向为竖向的布局，可容纳多个组件，可以通过属性控制排布的对齐方式。"
    )

    val row = WidgetModel(
        id = 2,
        name = "Row",
        nameCN = "行布局组件",
        lever = 4,
        family = "多内容组件",
        collectd = true,
        info = "水平方向为竖向的布局，可容纳多个组件，可以通过属性控制排布的对齐方式。"
    )

    Scaffold(
        backgroundColor = Color(0xffF3F5F4),
        topBar = {
            TopAppBar(
                title = { Text(title) },
            )
        }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UnitWidgetItemV1(model = text)
            Spacer(Modifier.height(10.dp))
            UnitWidgetItemV1(model =column)
            Spacer(Modifier.height(10.dp))
            UnitWidgetItemV1(model =row)
//            WeChatItem(banned = true)
//            JuejinArticleItemV0()

//            Text(text = "content")
        }
    }
}