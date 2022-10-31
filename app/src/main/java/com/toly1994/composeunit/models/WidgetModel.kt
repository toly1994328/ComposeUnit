package com.toly1994.composeunit.models

data class WidgetModel(
    val id: Long,
    val name: String,
    val nameCN: String,
    val info: String,
    val family: String,
    val lever: Int,
    val collectd: Boolean,
)
