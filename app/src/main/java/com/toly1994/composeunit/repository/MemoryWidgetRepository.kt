package com.toly1994.composeunit.repository

import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.memory.MemoryWidgetDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MemoryWidgetRepository : WidgetRepository {

    override fun getAllWidget(): Flow<List<WidgetModel>> = flow {
        emit(MemoryWidgetDataStore.allWidget)
    }

}