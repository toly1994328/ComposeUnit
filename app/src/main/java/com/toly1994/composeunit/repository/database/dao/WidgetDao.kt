package com.toly1994.composeunit.repository.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.toly1994.composeunit.repository.database.entity.WidgetPo

@Dao
interface WidgetDao {
    @Query("SELECT * FROM widget")
    fun queryAll():List<WidgetPo>?

    @Query("SELECT * FROM widget WHERE id = :id")
    fun queryById(id:Int):List<WidgetPo>?

    @Query("SELECT * FROM widget WHERE name LIKE :arg OR name_cn LIKE :arg")
    fun searchByName(arg:String):List<WidgetPo>?

    @Insert
    fun insertAll(vararg widgetPo: WidgetPo)

    @Delete
    fun delete(widgetPo: WidgetPo)
}