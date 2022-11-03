package com.toly1994.composeunit.repository.memory

import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.repository.memory.node_res.*

object MemoryNodeDataStore {
    val allNodes = listOf(
        NodeModel(
            widgetId = 1,
            name = "文字的基本样式",
            code = textNode1Code,
            info = textNode1Info
        ),
        NodeModel(
            widgetId = 1,
            name = "文字背景与阴影",
            code = textNode2Code,
            info = textNode2Info
        ),
        NodeModel(
            widgetId = 1,
            name = "文字装饰线与缩进",
            code = textNode3Code,
            info = textNode3Info
        ),
        NodeModel(
            widgetId = 1,
            name = "多行与包裹溢出",
            code = textNode4Code,
            info = textNode4Info
        ),      NodeModel(
            widgetId = 1,
            name = "文字对齐与行高",
            code = textNode5Code,
            info = textNode5Info
        ),
    )
}