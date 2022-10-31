package com.toly1994.composeunit.app.navigation

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.toly1994.composeunit.app.splash.UnitSplash
import com.toly1994.composeunit.details.WidgetDetail
import com.toly1994.composeunit.doing.Doing
import com.toly1994.composeunit.home.HomeLazyWidgetList
import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.user.UnitUserPage

@Composable
fun UnitNavigation() {
    val topNavCtrl = rememberNavController()
    NavHost(
        navController = topNavCtrl,
        startDestination = UnitRoute.homeNav
    ) {
        composable(UnitRoute.splash) { UnitSplash() }
        composable(UnitRoute.homeNav) { UnitHomeNavigation(topNavCtrl) }
        composable(
            UnitRoute.widgetDetail + "/{widgetId}/{widgetName}",
            arguments = listOf(navArgument("widgetId") { type = NavType.IntType },
                navArgument("widgetName") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("widgetId");
            val name = backStackEntry.arguments?.getString("widgetName")
            WidgetDetail(widgetId = id, widgetName = name) {
                topNavCtrl.popBackStack()
            }
        }
    }
//    delayToHome(topNavCtrl)
}

private fun delayToHome(topNavCtrl: NavHostController, duration: Long = 1000) {
    Handler(Looper.getMainLooper()).postDelayed({
        topNavCtrl.navigate(UnitRoute.homeNav) {
            popUpTo(UnitRoute.splash) {
                inclusive = true
            }
        }
    }, duration)
}

@Composable
fun UnitHomeNavigation(
    topNavCtrl: NavHostController,
) {
    val navCtrl = rememberNavController()
    val navEntry = navCtrl.currentBackStackEntryAsState()
    val currentRout: String? = navEntry.value?.destination?.route
    Scaffold(backgroundColor = Color(0xffF3F5F4), bottomBar = {
        UnitBottomNavBar(currentRoute = currentRout, onTapItem = { navigatorTo(navCtrl, it) })
    }, topBar = {
        UnitAppBar(currentRout)
    }) {
        NavHost(navCtrl, startDestination = UnitRoute.widget, Modifier.padding(it)) {
            composable(UnitRoute.widget) {
                HomeLazyWidgetList() { model ->
                    toWidgetDetail(topNavCtrl, model)
                }
            }
            composable(UnitRoute.layout) { Doing(name = "布局集录") }
            composable(UnitRoute.collect) { Doing(name = "收藏集录") }
            composable(UnitRoute.user) { UnitUserPage() }
        }
    }
}



@Composable
fun UnitBottomNavBar(
    currentRoute: String?,
    onTapItem: (String) -> Unit,
) {
    BottomNavigation() {
        RouterRes.bottomNavData.forEach { data ->
            BottomNavigationItem(selected = currentRoute == data.route,
                onClick = { onTapItem(data.route) },
                label = { Text(text = data.text) },
                icon = {
                    Icon(
                        imageVector = data.icon, contentDescription = ""
                    )
                })
        }
    }
}

// 路由跳转
private fun navigatorTo(
    navCtrl: NavHostController, route: String
) {
    navCtrl.navigate(route) {
        popUpTo(navCtrl.graph.findStartDestination().id) {
            saveState = true
        }
        restoreState = true
    }
}

// 跳转到组件详情页
private fun toWidgetDetail(
    navCtrl: NavHostController,
    model: WidgetModel,
) {
    navCtrl.navigate(UnitRoute.widgetDetail + "/${model.id}" + "/${model.name}")
}

