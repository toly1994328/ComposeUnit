package com.toly1994.composeunit.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.toly1994.composeunit.models.WidgetModel

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
    val collectd: Int, // 对应关系见 [PoMap#widgetCollectdMap]
    @ColumnInfo
    val family: Int, // 对应关系见 [PoMap#widgetFamilyMap]
){
    fun toModel(): WidgetModel {
        val collectdValue = WidgetPoMap.widgetCollectdMap.keys.toList()[collectd]
        val familyValue = WidgetPoMap.widgetFamilyMap.keys.toList()[family]
        return WidgetModel(
            id, name, nameCN, info, familyValue,lever, collectdValue,
        )
    }
}

object WidgetPoMap {
    // // 收藏 0  未收藏 1
    val widgetCollectdMap = mapOf(
        false  to 0,
        true  to 1,
    )
    val widgetFamilyMap = mapOf(
       "无内容组件"  to 0,
       "单内容组件"  to 1,
       "多内容组件"  to 2,
       "卡槽型组件"  to 3,
    )
}