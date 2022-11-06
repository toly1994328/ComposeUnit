package com.toly1994.composeunit.app

import androidx.compose.runtime.Composable
import com.toly1994.composeunit.app.data_manager.DataManagePage
import com.toly1994.composeunit.app.navigation.UnitNavigation
import com.toly1994.composeunit.details.WidgetDetail
import com.toly1994.composeunit.layouts.counter.CountViewModel
import com.toly1994.composeunit.layouts.counter.CounterPageV2
import com.toly1994.composeunit.layouts.github_search.views.GithubSearchPage
import com.toly1994.composeunit.widgets.Center
import com.toly1994.composeunit.widgets.WidgetNodeMap

@Composable
fun ComposeUnitApp(
    onShare: (String) -> Unit,
) {
    UnitNavigation(onShare=onShare)
//    DataManagePage()
//     GithubSearchPage()
//    CounterPageV2(title = "计时器 ViewModel + Flow")
//    WidgetDetail(onShare = onShare) {
//
//    }
//    Center {
//        WidgetNodeMap(10,0)
//    }

}


