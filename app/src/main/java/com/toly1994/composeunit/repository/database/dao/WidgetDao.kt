package com.toly1994.composeunit.repository.database.dao

import androidx.room.*
import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.database.entity.WidgetPo
import com.toly1994.composeunit.repository.database.entity.WidgetPoMap
import kotlinx.coroutines.flow.Flow

@Dao
interface WidgetDao {
    @Query("SELECT * FROM widget")
    fun queryAll(): Flow<List<WidgetPo>>

    @Query("SELECT * FROM widget WHERE id = :id")
    fun queryById(id:Int):Flow<List<WidgetPo>>

    @Query("SELECT * FROM widget WHERE name LIKE :arg OR name_cn LIKE :arg")
    fun searchByName(arg:String): Flow<List<WidgetPo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg widgetPo: WidgetPo)

    @Delete
    fun delete(widgetPo: WidgetPo)

    @Query("DELETE from widget")
    fun deleteAll()
}