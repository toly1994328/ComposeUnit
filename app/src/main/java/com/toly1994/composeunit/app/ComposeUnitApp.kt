package com.toly1994.composeunit.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.toly1994.composeunit.app.navigation.UnitHomeNavigation
import com.toly1994.composeunit.app.navigation.UnitNavigation
import com.toly1994.composeunit.app.navigation.UnitRoute
import com.toly1994.composeunit.details.WidgetDetail
import com.toly1994.composeunit.widgets.Text.TextNode1

@Composable
fun ComposeUnitApp(
    onShare: (String) -> Unit,
) {
//    UnitNavigation(onShare)
    WidgetDetail(widgetId = 1, widgetName = "",onShare=onShare) {

    }
}


