package com.toly1994.composeunit.models

import com.toly1994.composeunit.repository.database.entity.WidgetPo
import com.toly1994.composeunit.repository.database.entity.WidgetPoMap

data class WidgetModel(
    val id: Int,
    val name: String,
    val nameCN: String,
    val info: String,
    val family: String,
    val lever: Int,
    val collectd: Boolean,
) {
    fun toPo(): WidgetPo {
        val collectdValue = WidgetPoMap.widgetCollectdMap[collectd]!!
        val familyValue = WidgetPoMap.widgetFamilyMap[family]!!
        return WidgetPo(
            id, name, nameCN, info, lever, collectdValue, familyValue,
        )
    }
}
