package com.toly1994.composeunit.home

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.toly1994.composeunit.layouts.UnitWidgetItemV1
import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.memory.MemoryWidgetDataStore

@Composable
fun HomeWidgetList() {
    Column(
        Modifier
            .verticalScroll(ScrollState(0))
            .padding(bottom = 20.dp)
    ) {
        MemoryWidgetDataStore.allWidget.forEach { widget ->
            Box(modifier = Modifier.padding(top = 10.dp)) {
                UnitWidgetItemV1(model = widget)
            }
        }
    }
}

@Composable
fun HomeLazyWidgetList(
    onTapItem: (WidgetModel) -> Unit,
) {
    val data = MemoryWidgetDataStore.allWidget;
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp)
    ) {
        itemsIndexed(data) { index, widget ->
            UnitWidgetItemV1(model = widget,
                modifier = Modifier.clickable {
                    onTapItem(widget)
                })
            Log.d("HomeLazyWidgetList", "$index")
        }
    }
}