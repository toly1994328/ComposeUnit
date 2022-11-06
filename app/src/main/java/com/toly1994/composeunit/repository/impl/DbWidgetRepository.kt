package com.toly1994.composeunit.repository.impl

import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.WidgetRepository
import com.toly1994.composeunit.repository.database.LocalDb
import com.toly1994.composeunit.repository.memory.MemoryWidgetDataStore
import kotlinx.coroutines.flow.*


class DbWidgetRepository : WidgetRepository {

    override fun queryAllWidget(): Flow<List<WidgetModel>> {
        val pos = LocalDb.database.widgetDao().queryAll()
        return pos.map { it.map { po -> po.toModel() } }
    }

    override fun searchWidget(arg: String): Flow<List<WidgetModel>>  {
        val pos = LocalDb.database.widgetDao().searchByName(arg)
        return pos.map { it.map { po -> po.toModel() } }
    }
}