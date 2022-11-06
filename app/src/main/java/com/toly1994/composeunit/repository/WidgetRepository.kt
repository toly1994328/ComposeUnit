package com.toly1994.composeunit.repository

import com.toly1994.composeunit.models.WidgetModel
import kotlinx.coroutines.flow.Flow

interface WidgetRepository {
    fun queryAllWidget(): Flow<List<WidgetModel>>

    fun searchWidget(arg:String): Flow<List<WidgetModel>>
}