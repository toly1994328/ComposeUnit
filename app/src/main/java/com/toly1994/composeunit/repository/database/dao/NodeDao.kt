package com.toly1994.composeunit.repository.database.dao

import androidx.room.*
import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.database.entity.WidgetPo
import com.toly1994.composeunit.repository.database.entity.WidgetPoMap
import kotlinx.coroutines.flow.Flow

@Dao
interface NodeDao {
    @Query("SELECT * FROM node WHERE widget_id = :widgetId")
    fun queryByWidgetId(widgetId:Int):Flow<List<NodeModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg data: NodeModel)

    @Query("DELETE from node")
    fun deleteAll()
}