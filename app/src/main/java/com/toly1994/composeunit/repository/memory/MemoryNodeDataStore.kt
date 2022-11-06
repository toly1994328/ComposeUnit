package com.toly1994.composeunit.repository.memory

import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.repository.memory.node_res.*

object MemoryNodeDataStore {
    val allNodes = listOf(
        //==== Text ==========
        NodeModel(
            widgetId = 1,
            name = "文字的基本样式",
            code = TextNode1Code,
            info = TextNode1Info
        ),
        NodeModel(
            widgetId = 1,
            name = "文字背景与阴影",
            code = TextNode2Code,
            info = TextNode2Info
        ),
        NodeModel(
            widgetId = 1,
            name = "文字装饰线与缩进",
            code = TextNode3Code,
            info = TextNode3Info
        ),
        NodeModel(
            widgetId = 1,
            name = "多行与包裹溢出",
            code = TextNode4Code,
            info = TextNode4Info
        ),
        NodeModel(
            widgetId = 1,
            name = "文字对齐与行高",
            code = TextNode5Code,
            info = TextNode5Info
        ),
        //==== Image ==========
        NodeModel(
            widgetId = 2,
            name = "图片加载方式",
            code = ImageNode1Code,
            info = ImageNode1Info
        ),
        NodeModel(
            widgetId = 2,
            name = "图片对齐模式",
            code = ImageNode2Code,
            info = ImageNode2Info
        ),
        NodeModel(
            widgetId = 2,
            name = "图片缩放模式",
            code = ImageNode3Code,
            info = ImageNode3Info
        ),
        NodeModel(
            widgetId = 2,
            name = "颜色叠合模式",
            code = ImageNode4Code,
            info = ImageNode4Info
        ),
        //==== Icon ==========
        NodeModel(
            widgetId = 3,
            name = "图标的使用",
            code = IconNode1Code,
            info = IconNode1Info
        ),
        //==== Row ==========
        NodeModel(
            widgetId = 4,
            name = "行的水平对齐模式",
            code = RowNode1Code,
            info = RowNode1Info
        ),
        NodeModel(
            widgetId = 4,
            name = "行的竖直对齐模式",
            code = RowNode2Code,
            info = RowNode2Info
        ),
        NodeModel(
            widgetId = 4,
            name = "行中的组件宽度占比",
            code = RowNode3Code,
            info = RowNode3Info
        ),
        //==== Column ==========
        NodeModel(
            widgetId = 5,
            name = "列的竖直对齐模式",
            code = ColumnNode1Code,
            info = ColumnNode1Info
        ),
        NodeModel(
            widgetId = 5,
            name = "列的水平对齐模式",
            code = ColumnNode2Code,
            info = ColumnNode2Info
        ),
        NodeModel(
            widgetId = 5,
            name = "列中的组件高度占比",
            code = ColumnNode3Code,
            info = ColumnNode3Info
        ),
        //==== Box ==========
        NodeModel(
            widgetId = 6,
            name = "Box 的对齐方式",
            code = BoxNode1Code,
            info = BoxNode1Info
        ),
        NodeModel(
            widgetId = 6,
            name = "修改单个子组件的对齐方式",
            code = BoxNode2Code,
            info = BoxNode2Info
        ),
        //==== LazyColumn ==========
        NodeModel(
            widgetId = 7,
            name = "延迟纵向列表基本使用",
            code = LazyColumnNode1Code,
            info = LazyColumnNode1Info
        ),
        //==== LazyColumn ==========
        NodeModel(
            widgetId = 8,
            name = "延迟横向列表基本使用",
            code = LazyRowNode1Code,
            info = LazyRowNode1Info
        ),
        //==== LazyVerticalGrid ==========
        NodeModel(
            widgetId = 9,
            name = "延迟纵向网格基本使用",
            code = LazyVerticalGridNode1Code,
            info = LazyVerticalGridNode1Info
        ),
        //==== LazyHorizontalGrid ==========
        NodeModel(
            widgetId = 10,
            name = "延迟横向网格基本使用",
            code = LazyHorizontalGridNode1Code,
            info = LazyHorizontalGridNode1Info
        ),
    )
}