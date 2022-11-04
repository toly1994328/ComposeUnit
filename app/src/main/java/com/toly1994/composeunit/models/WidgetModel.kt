package com.toly1994.composeunit.models

import com.toly1994.composeunit.repository.database.entity.PoMap
import com.toly1994.composeunit.repository.database.entity.WidgetPo

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
        val collectd = if (this.collectd) 1 else 0;
        return WidgetPo(
            id, name, nameCN, info, lever, collectd, PoMap.familyMap2[family],
        )
    }
}
