package com.toly1994.composeunit.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.ui.graphics.vector.ImageVector

object UnitRoute {
    const val homeNav = "HomeNav"
    const val splash = "Splash"
    const val widgetDetail = "WidgetDetail"
    const val widget = "HomeNav/Widget"
    const val layout = "HomeNav/Layout"
    const val collect = "HomeNav/Collect"
    const val user = "HomeNav/User"
}

object RouterRes {
    val bottomNavData = listOf(
        BottomNavData(
            route = UnitRoute.widget,
            icon = Icons.Default.Home,
            text = "组件",
        ),
        BottomNavData(
            route = UnitRoute.layout,
            icon = Icons.Default.Send,
            text = "布局",
        ),
        BottomNavData(
            route = UnitRoute.collect,
            icon = Icons.Default.Favorite,
            text = "收藏",
        ),
        BottomNavData(
            route = UnitRoute.user,
            icon = Icons.Default.AccountBox,
            text = "我的",
        ),
    )
}

data class BottomNavData(
    val route: String,
    val icon: ImageVector,
    val text: String
)

