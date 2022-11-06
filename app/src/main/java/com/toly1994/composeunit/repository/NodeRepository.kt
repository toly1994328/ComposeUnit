package com.toly1994.composeunit.repository

import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.models.WidgetModel
import kotlinx.coroutines.flow.Flow

interface NodeRepository {
    fun queryNodeByWidgetId(widgetId:Int): Flow<List<NodeModel>>
}