package com.toly1994.composeunit.repository.impl

import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.repository.NodeRepository
import com.toly1994.composeunit.repository.memory.MemoryNodeDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MemoryNodeRepository : NodeRepository {

    override fun queryNodeByWidgetId(widgetId: Int): Flow<List<NodeModel>> = flow {
        val nodes = MemoryNodeDataStore.allNodes.filter { model -> model.widgetId == widgetId }
        emit(nodes)
    }

}