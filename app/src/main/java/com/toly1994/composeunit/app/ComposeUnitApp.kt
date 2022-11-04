package com.toly1994.composeunit.app

import androidx.compose.runtime.Composable
import com.toly1994.composeunit.app.navigation.UnitNavigation
import com.toly1994.composeunit.details.WidgetDetail

@Composable
fun ComposeUnitApp(
    onShare: (String) -> Unit,
) {
//    UnitNavigation(onShare)
    WidgetDetail(widgetId = 5, widgetName = "", onShare = onShare) {

    }
}


