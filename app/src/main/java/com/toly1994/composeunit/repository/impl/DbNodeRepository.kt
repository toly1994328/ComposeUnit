package com.toly1994.composeunit.repository.impl

import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.repository.NodeRepository
import com.toly1994.composeunit.repository.database.LocalDb
import com.toly1994.composeunit.repository.memory.MemoryNodeDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class DbNodeRepository : NodeRepository {

    override fun queryNodeByWidgetId(widgetId: Int): Flow<List<NodeModel>> {
        return  LocalDb.database.nodeDao().queryByWidgetId(widgetId)
    }

}