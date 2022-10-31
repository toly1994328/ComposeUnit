package com.toly1994.composeunit.repository.memory

import com.toly1994.composeunit.models.WidgetModel

object MemoryWidgetDataStore {
    val allWidget = listOf(
        WidgetModel(
            id = 1,
            name = "Text",
            nameCN = "文字组件",
            lever = 5,
            family = "无内容组件",
            collectd = true,
            info = "用于显示文字的组件。拥有的属性非常多，足够满足你的使用需求,核心样式由style属性控制。"
        ),
        WidgetModel(
            id = 2,
            name = "Image",
            nameCN = "图片组件",
            lever = 5,
            family = "无内容组件",
            collectd = true,
            info = "用于显示一张图片，可以从资源文件中加载。可以指定适应方式、当前模式、颜色混合模式、透明度等属性。"
        ),
        WidgetModel(
            id = 3,
            name = "Column",
            nameCN = "列布局组件",
            lever = 5,
            family = "多内容组件",
            collectd = false,
            info = "排布方向为竖向的布局，可容纳多个组件，可以通过属性控制排布的对齐方式。"
        ),
        WidgetModel(
            id = 4,
            name = "Row",
            nameCN = "行布局组件",
            lever = 5,
            family = "多内容组件",
            collectd = true,
            info = "水平方向为竖向的布局，可容纳多个组件，可以通过属性控制排布的对齐方式。"
        ),
        WidgetModel(
            id = 5,
            name = "Box",
            nameCN = "叠放盒组件",
            lever = 5,
            family = "多内容组件",
            collectd = true,
            info = "可容纳多个组件，堆叠排放，可以通过属性控制排布的对齐方式等属性。"
        ),
        WidgetModel(
            id = 6,
            name = "Scaffold",
            nameCN = "脚手架组件",
            lever = 4,
            family = "卡槽型组件",
            collectd = true,
            info = "一个通用 app 结构，包括上、下、左、右、中、浮动按钮部位，对应位置可盛放组件。"
        ),
        WidgetModel(
            id = 7,
            name = "AppTopBar",
            nameCN = "应用头部栏",
            lever = 4,
            family = "卡槽型组件",
            collectd = true,
            info = "一个应用顶部栏的通用结构，可在指定的部位放置相应的组件，常用于Scaffold组件中。"
        ),
        WidgetModel(
            id = 8,
            name = "FloatingActionButton",
            nameCN = "浮动按钮",
            lever = 3,
            family = "单内容组件",
            collectd = true,
            info = "Material 风格，一般用于Scaffold中，可摆放在特定位置。可盛放一个子组件,接收点击、可定义颜色、形状等。"
        ),
        WidgetModel(
            id = 9,
            name = "Icon",
            nameCN = "图标组件",
            lever = 3,
            family = "无内容组件",
            collectd = false,
            info = "用于图标显示的组件。可指定图标资源、颜色。非常简单，但是非常用。"
        ),
        WidgetModel(
            id = 10,
            name = "Spacer",
            nameCN = "占位组件",
            lever = 4,
            family = "无内容组件",
            collectd = false,
            info = "只有 modifier 参数的组件，一般用于占位场景。"
        ),
        WidgetModel(
            id = 11,
            name = "Divider",
            nameCN = "分割线组件",
            lever = 2,
            family = "无内容组件",
            collectd = false,
            info = "横向分割线，默认 1dp，可指定头部空缺长度。"
        )
    )
}