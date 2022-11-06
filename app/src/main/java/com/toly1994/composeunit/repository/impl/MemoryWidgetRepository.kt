package com.toly1994.composeunit.repository.impl

import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.WidgetRepository
import com.toly1994.composeunit.repository.memory.MemoryWidgetDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MemoryWidgetRepository : WidgetRepository {

    override fun queryAllWidget(): Flow<List<WidgetModel>> = flow {
        emit(MemoryWidgetDataStore.allWidget)
    }

    override fun searchWidget(arg: String): Flow<List<WidgetModel>> = flow {
        emit(MemoryWidgetDataStore.allWidget.filter { model ->
            model.name.contains(arg, ignoreCase = true) || model.nameCN.contains(
                arg, ignoreCase = true
            )
        })
    }

}