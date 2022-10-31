package com.toly1994.composeunit

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.toly1994.composeunit.app.ComposeUnitApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        WindowCompat.setDecorFitsSystemWindows(window,true)
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUnitApp()
        }
    }
}
/**
 * 设置透明状态栏
 */
fun Activity.transparentStatusBar() {
    transparentStatusBar(window)
}

private fun transparentStatusBar(window: Window) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    val option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    val vis = window.decorView.systemUiVisibility
    window.decorView.systemUiVisibility = option or vis
    window.statusBarColor = Color.TRANSPARENT
}

/**
 * 状态栏反色
 */
fun Activity.setAndroidNativeLightStatusBar() {
    val decor = window.decorView
    val isDark = resources.configuration.uiMode == 0x21
    if (!isDark) {
        decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
        decor.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}

//fun transparentStatusBar(activity: Activity) {
//    transparentStatusBar(activity.window)
//}
//
//fun transparentStatusBar(window: Window) {
//    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//    val option: Int = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//    val vis: Int = window.getDecorView().getSystemUiVisibility()
//    window.getDecorView().setSystemUiVisibility(option or vis)
//    activity.
//}

//@Composable
//fun ComposeUnitApp() {
//    HomePage(title = "Compose Demo Home Page")
//}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeUnitTheme {
//        Greeting("Android")
//    }
//}