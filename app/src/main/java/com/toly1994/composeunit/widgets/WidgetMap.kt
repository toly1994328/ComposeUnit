package com.toly1994.composeunit.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.toly1994.composeunit.widgets.Box.BoxNode1
import com.toly1994.composeunit.widgets.Box.BoxNode2
import com.toly1994.composeunit.widgets.Column.ColumnNode1
import com.toly1994.composeunit.widgets.Column.ColumnNode2
import com.toly1994.composeunit.widgets.Column.ColumnNode3
import com.toly1994.composeunit.widgets.Icon.IconNode1
import com.toly1994.composeunit.widgets.Image.ImageNode1
import com.toly1994.composeunit.widgets.Image.ImageNode2
import com.toly1994.composeunit.widgets.Image.ImageNode3
import com.toly1994.composeunit.widgets.Image.ImageNode4
import com.toly1994.composeunit.widgets.LazyColumn.LazyColumnNode1
import com.toly1994.composeunit.widgets.LazyHorizontalGrid.LazyHorizontalGridNode1
import com.toly1994.composeunit.widgets.LazyRow.LazyRowNode1
import com.toly1994.composeunit.widgets.LazyVerticalGrid.LazyVerticalGridNode1
import com.toly1994.composeunit.widgets.Row.RowNode1
import com.toly1994.composeunit.widgets.Row.RowNode2
import com.toly1994.composeunit.widgets.Row.RowNode3
import com.toly1994.composeunit.widgets.Text.*

@Composable
fun WidgetNodeMap(widgetId: Int, index: Int) {
    if (widgetId == 1 && index == 0) Playground { TextNode1() }
    if (widgetId == 1 && index == 1) Center { TextNode2() }
    if (widgetId == 1 && index == 2) Center { TextNode3() }
    if (widgetId == 1 && index == 3) Center { TextNode4() }
    if (widgetId == 1 && index == 4) Center { TextNode5() }
    if (widgetId == 2 && index == 0) ImageNode1()
    if (widgetId == 2 && index == 1) ImageNode2()
    if (widgetId == 2 && index == 2) ImageNode3()
    if (widgetId == 2 && index == 3) ImageNode4()
    if (widgetId == 3 && index == 0) IconNode1()
    if (widgetId == 4 && index == 0) RowNode1()
    if (widgetId == 4 && index == 1) RowNode2()
    if (widgetId == 4 && index == 2) Center { RowNode3() }
    if (widgetId == 5 && index == 0) ColumnNode1()
    if (widgetId == 5 && index == 1) ColumnNode2()
    if (widgetId == 5 && index == 2) Center { ColumnNode3() }
    if (widgetId == 6 && index == 0) Center { BoxNode1() }
    if (widgetId == 6 && index == 1) Center { BoxNode2() }
    if (widgetId == 7 && index == 0) Center {LazyColumnNode1()}
    if (widgetId == 8 && index == 0) Center {LazyRowNode1()}
    if (widgetId == 9 && index == 0) Center {LazyVerticalGridNode1()}
    if (widgetId == 10 && index == 0) Center { LazyHorizontalGridNode1() }
}

@Composable
fun Playground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            Modifier
                .width(200.dp)
                .height((0.618 * 0.618 * 200).dp),
            color = Color(0xffEFEFEF)
        ) { content() }
    }
}

@Composable
fun Center(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}