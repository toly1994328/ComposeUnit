package com.toly1994.composeunit.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "node")
data class NodeModel(
    @ColumnInfo(name = "widget_id")
    val widgetId: Int,
    @PrimaryKey
    val name: String,
    @ColumnInfo
    val info: String,
    @ColumnInfo
    val code: String,
)
