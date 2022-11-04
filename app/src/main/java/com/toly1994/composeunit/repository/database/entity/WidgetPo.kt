package com.toly1994.composeunit.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "widget")
data class WidgetPo(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val name: String,
    @ColumnInfo(name = "name_cn")
    val nameCN: String,
    @ColumnInfo
    val info: String,
    @ColumnInfo
    val lever: Int,
    @ColumnInfo
    val collectd: Int, // 收藏 0  未收藏 1
    @ColumnInfo
    val family: Int?, // 对应关系见 [PoMap#familyMap]
)

object PoMap {
    val familyMap = mapOf(
        0 to "无内容组件",
        1 to "单内容组件",
        2 to "多内容组件",
        3 to "卡槽型组件",
    )
    val familyMap2 = mapOf(
       "无内容组件"  to 0,
       "单内容组件"  to 1,
       "多内容组件"  to 2,
       "卡槽型组件"  to 3,
    )
}