package com.toly1994.composeunit.repository.memory.node_res

const val TextNode1Code =
"""@Composable
fun TextNode1(){
    val style = TextStyle(
        color = Color.Blue,
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        letterSpacing = 10.sp
    )
    Text(
        text = "toly-张风捷特烈-1994`",
        style = style
    )
}"""

const val TextNode1Info =
"""【text】 : 文字  【String】
【style】: 文字样式   【TextStyle】
【color】: 文字颜色   【Color】
【fontSize】: 文字大小   【TextUnit】
【fontWeight】: 字重   【FontWeight?】
【fontStyle】: 字体样式   【FontStyle?】
【letterSpacing】: 字距   【TextUnit】"""

const val TextNode2Code =
"""@Composable
fun TextNode2() {
    val style = TextStyle(
        color = Color.White,
        fontSize = 50.sp,
        background = Color.Black,
        shadow = Shadow(
            color = Color.Cyan,
            offset = Offset(1f,1f),
            blurRadius = 10f
        )
    )
    Text(
        text = "张风捷特烈",
        style = style,
    )
}"""

const val TextNode2Info =
"""【backgroundColor】 : 背景颜色  【Color】
【shadow】: 阴影   【Shadow】"""

const val TextNode3Code =
    """@Composable
fun TextNode3() {
    val style1 = TextStyle(
        fontSize = 25.sp,
        textDecoration = TextDecoration.LineThrough
    )
    val style2 = TextStyle(
        fontSize = 25.sp,
        textIndent = TextIndent(20.sp),
        textDecoration = TextDecoration.Underline
    )
    Row{
        Text(
            text = "张风捷特烈",
            style = style1,
        )
        Text(
            text = "张风捷特烈",
            style = style2,
        )
    }
}"""

const val TextNode3Info =
    """【textDecoration】 : 文字装饰  【TextDecoration】
【textIndent】: 文字缩进   【textIndent】"""


const val TextNode4Code =
    """@Composable
fun TextNode4() {
    Text(
        modifier = Modifier
            .width(200.dp)
            .background(Color(0xffEFEFEF))
            .padding(10.dp),
        text = "ComposeUnit is an application for learn Compose.",
        fontSize = 16.sp,
        softWrap = true,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
    )
}"""

const val TextNode4Info =
    """【softWrap】 : 是否自动换行  【Boolean】
【overflow】: 溢出方式   【TextOverflow】
【maxLines】: 最大行数   【Int】"""


const val TextNode5Code = "@Composable\n" +
        "fun TextNode5() {\n" +
        "    val data = arrayOf(\n" +
        "        TextAlign.Start,\n" +
        "        TextAlign.Center,\n" +
        "        TextAlign.End,\n" +
        "        TextAlign.Justify,\n" +
        "        TextAlign.Right,\n" +
        "        TextAlign.Left,\n" +
        "    )\n" +
        "\n" +
        "    Column {\n" +
        "        for (index in data.indices step 2) {\n" +
        "            Row(\n" +
        "                Modifier.fillMaxWidth(),\n" +
        "                horizontalArrangement = Arrangement.SpaceEvenly,\n" +
        "                verticalAlignment = Alignment.CenterVertically\n" +
        "            ) {\n" +
        "                TextAlignItem(data[index])\n" +
        "                TextAlignItem(data[index + 1])\n" +
        "            }\n" +
        "        }\n" +
        "    }\n" +
        "}\n" +
        "\n" +
        "@Composable\n" +
        "fun TextAlignItem(align: TextAlign) {\n" +
        "    Column(horizontalAlignment = Alignment.CenterHorizontally) {\n" +
        "        Box(\n" +
        "            modifier = Modifier.width(150.dp).height(90.dp)\n" +
        "                .padding(bottom = 3.dp).background(Color(0xffEFEFEF))\n" +
        "        ) {\n" +
        "            Text(\n" +
        "                text = \"ComposeUnit is an application for learn Compose.\",\n" +
        "                textAlign = align,\n" +
        "                lineHeight = 20.sp\n" +
        "            )\n" +
        "        }\n" +
        "        Text(text = \"TextAlign.\$align\", color = Color.Gray, fontSize = 12.sp)\n" +
        "        Spacer(modifier = Modifier.height(5.dp))\n" +
        "    }\n" +
        "}"

const val TextNode5Info =
    """【textAlign】: 文字对齐   【TextAlign?】
【lineHeight】 : 行高  【TextUnit】"""

const val ImageNode1Code =
    """@Composable
fun ImageNode1() {
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.mipmap.logo),
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
        Image(
            imageVector = Icons.Default.Lock,
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
        val imageBitmap = ImageBitmap.imageResource(R.mipmap.icon_head)
        Image(
            bitmap = imageBitmap,
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
        Image(
            painter = painterResource(id = R.mipmap.logo),
            modifier = Modifier.width(60.dp).height(60.dp),
            alpha = 0.5f,
            contentDescription = null,
        )
    }
}"""


const val ImageNode1Info =
    """【painter】 : 画板加载  【Painter】
【imageVector】: 矢量图片   【ImageVector】
【bitmap】: 位图加载   【ImageBitmap】
【alpha】: 透明度   【Float】
【contentDescription】: 无障碍描述   【String?】"""

const val ImageNode2Code = """@Composable
fun ImageNode2() {
    val data = mapOf(
        Alignment.Center to "Center",
        Alignment.CenterStart to "CenterStart",
        Alignment.CenterEnd to "CenterEnd",
        Alignment.TopCenter to "TopCenter",
        Alignment.BottomCenter to "BottomCenter",
        Alignment.BottomStart to "BottomStart",
        Alignment.BottomEnd to "BottomEnd",
        Alignment.TopStart to "TopStart",
        Alignment.TopEnd to "TopEnd",

    )
    val keys = data.keys.toList();
    val values = data.values.toList();
    Column {
        for (index in data.keys.indices step 3) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageAlignmentItem(keys[index],values[index])
                if(index+1<data.size)
                ImageAlignmentItem(keys[index+1],values[index+1])
                if(index+2<data.size)
                ImageAlignmentItem(keys[index+2],values[index+2])
            }
        }
    }
}

@Composable
fun ImageAlignmentItem(alignment: Alignment ,info: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.width(80.dp).height(50.dp)
                .padding(bottom = 3.dp).background(Color(0xffEFEFEF))
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo_mini),
                modifier = Modifier.width(80.dp).height(50.dp),
                alignment = alignment,
                contentScale = ContentScale.None,
                contentDescription = null,
            )
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}"""
const val ImageNode2Info = """【alignment】 : 对齐模式  【Alignment】"""


const val ImageNode3Code =
    """@Composable
fun ImageNode2() {
    val data = mapOf(
        ContentScale.Fit to "Fit",
        ContentScale.Crop to "Crop",
        ContentScale.FillHeight to "FillHeight",
        ContentScale.FillWidth to "FillWidth",
        ContentScale.FillBounds to "FillBounds",
        ContentScale.None to "None",
        ContentScale.Inside to "Inside",
    )
    val keys = data.keys.toList();
    val values = data.values.toList();
    Column {
        for (index in data.keys.indices step 2) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageContentScaleItem(keys[index],values[index])
                if(index<data.size-1)
                ImageContentScaleItem(keys[index+1],values[index+1])
            }
        }
    }
}

@Composable
fun ImageContentScaleItem(contentScale: ContentScale,info: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.width(150.dp).height(90.dp)
                .padding(bottom = 3.dp).background(Color(0xffEFEFEF))
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo),
                modifier = Modifier.width(150.dp).height(90.dp),
                contentScale = contentScale,
                contentDescription = null,
            )
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}"""


const val ImageNode3Info =
    """【contentScale】 : 缩放模式  【ContentScale】"""


const val ImageNode4Code = """@Composable
fun ImageNode4() {
    val data = arrayOf(
        BlendMode.Clear,BlendMode.Src,BlendMode.Dst,
        BlendMode.SrcOver,BlendMode.DstOver,BlendMode.SrcIn,
        BlendMode.DstIn,BlendMode.SrcOut,BlendMode.DstOut,
        BlendMode.SrcAtop,BlendMode.DstAtop,BlendMode.Xor,
        BlendMode.Plus,BlendMode.Modulate,BlendMode.Screen,
        BlendMode.Overlay,BlendMode.Darken,BlendMode.Lighten,
        BlendMode.ColorDodge,BlendMode.ColorBurn,BlendMode.Hardlight,
        BlendMode.Softlight,BlendMode.Difference,BlendMode.Exclusion,
        BlendMode.Multiply,BlendMode.Hue,BlendMode.Saturation,
        BlendMode.Color,BlendMode.Luminosity,)

    Column {
        for (index in data.indices step 5) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageBlendModeItem(data[index])
                if(index+1<data.size)
                    ImageBlendModeItem(data[index+1])
                if(index+2<data.size)
                    ImageBlendModeItem(data[index+2])
                if(index+3<data.size)
                    ImageBlendModeItem(data[index+3])
                if(index+4<data.size)
                    ImageBlendModeItem(data[index+4])
            }
        }
    }
}

@Composable
fun ImageBlendModeItem(blendMode: BlendMode) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.width(60.dp).height(60.dp)
                .padding(bottom = 3.dp).background(Color(0xffEFEFEF))
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo),
                modifier = Modifier.width(60.dp).height(60.dp),
                colorFilter = ColorFilter.tint(Color.Red, blendMode = blendMode),
                alpha = 0.8f,
                contentDescription = null,
            )
        }
        Text(text = blendMode.toString(), color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}"""
const val ImageNode4Info = """【colorFilter】 : 缩放模式  【ColorFilter】"""


const val IconNode1Code =
"""@Composable
fun IconNode1() {
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(id = R.mipmap.icon_code),
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.size(40.dp, 40.dp),
        )
        Icon(
            imageVector = Icons.Default.Lock,
            modifier = Modifier.width(50.dp).height(50.dp),
            tint = Color.Blue,
            contentDescription = null,
        )
        val imageBitmap = ImageBitmap.imageResource(R.mipmap.icon_kafi)
        Icon(
            bitmap = imageBitmap,
            tint = Color.Magenta,
            modifier = Modifier.width(60.dp).height(60.dp),
            contentDescription = null,
        )
    }
}"""

const val IconNode1Info =
"""【painter】 : 画板加载  【Painter】
【imageVector】: 矢量图片   【ImageVector】
【bitmap】: 位图加载   【ImageBitmap】
【tint】: 颜色   【Color】
【contentDescription】: 无障碍描述   【String?】"""

const val RowNode1Code =
"""@Composable
fun RowNode1() {
    val data = mapOf(
        Arrangement.Center to "Center",
        Arrangement.SpaceBetween to "SpaceBetween",
        Arrangement.SpaceAround to "SpaceAround",
        Arrangement.SpaceEvenly to "SpaceEvenly",
        Arrangement.End to "End",
        Arrangement.Start to "Start",
    )
    val keys = data.keys.toList();
    val values = data.values.toList();
    Column {
        for (index in data.keys.indices step 2) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RowHAItem(keys[index],values[index])
                if(index<data.size-1)
                    RowHAItem(keys[index+1],values[index+1])
            }
        }
    }

}
@Composable
fun RowHAItem(arrangement: Arrangement.Horizontal, info: String) {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            Modifier.width(150.dp).height(80.dp).background(Color(0xffEFEFEF)),
            horizontalArrangement = arrangement
        ) {
            colors.forEach {
                Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(it))
            }
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}"""

const val RowNode1Info =
"""【horizontalArrangement】 : 水平对齐  【Arrangement.Horizontal】
【content】: 内容组件列表   【@Composable RowScope.() -> Unit】"""

const val RowNode2Code =
"""@Composable
fun RowNode2() {
    val data = mapOf(
        Alignment.Top to "Top",
        Alignment.CenterVertically to "Center",
        Alignment.Bottom to "TopCenter",
    )
    val keys = data.keys.toList();
    val values = data.values.toList();
    Column {
        for (index in data.keys.indices step 2) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RowVAItem(keys[index],values[index])
                if(index<data.size-1)
                RowVAItem(keys[index+1],values[index+1])
            }
        }
    }
}
@Composable
fun RowVAItem(arrangement: Alignment.Vertical, info: String) {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            Modifier.width(150.dp).height(80.dp).background(Color(0xffEFEFEF)),
            verticalAlignment = arrangement
        ) {
            colors.forEach {
                Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(it))
            }
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}"""

const val RowNode2Info =
"""【verticalAlignment】 : 竖直对齐  【Arrangement.Vertical】"""


const val RowNode3Code =
"""@Composable
fun RowNode3() {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Row(
        Modifier.width(250.dp).height(100.dp).background(Color(0xffEFEFEF)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[0]))
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[1]).weight(1f))
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[2]).weight(2f))
    }
}"""

const val RowNode3Info =
"""Modifier 的 weight 属性只能用于 Row 和 Column 中，该案例里蓝色和绿色区域宽度占比 1:2，且无视盒自身宽度，使 Row 区域横向占满。"""

const val ColumnNode1Code =
"""@Composable
fun ColumnNode1() {
    val data = mapOf(
        Arrangement.Top to "Center",
        Arrangement.SpaceBetween to "SpaceBetween",
        Arrangement.SpaceAround to "SpaceAround",
        Arrangement.SpaceEvenly to "SpaceEvenly",
        Arrangement.Bottom to "End",
        Arrangement.Center to "Start",
    )
    val keys = data.keys.toList();
    val values = data.values.toList();
    Column {
        for (index in data.keys.indices step 3) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ColumnVAItem(keys[index],values[index])
                if(index+1<data.size)
                ColumnVAItem(keys[index+1],values[index+1])
                if(index+2<data.size)
                ColumnVAItem(keys[index+2],values[index+2])
            }
        }
    }
}
@Composable
fun ColumnVAItem(arrangement: Arrangement.Vertical, info: String) {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier.width(80.dp).height(150.dp).background(Color(0xffEFEFEF)),
            verticalArrangement = arrangement
        ) {
            colors.forEach {
                Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(it))
            }
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}"""

const val ColumnNode1Info =
"""【verticalArrangement】 : 竖直对齐模式  【Arrangement.Vertical】
【content】: 内容组件列表   【@Composable RowScope.() -> Unit】"""


const val ColumnNode2Code =
"""@Composable
fun ColumnNode2() {
    val data = mapOf(
        Alignment.Start to "Start",
        Alignment.CenterHorizontally to "CenterHorizontally",
        Alignment.End to "End",
    )
    val keys = data.keys.toList()
    val values = data.values.toList()
    Column {
        for (index in data.keys.indices step 2) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ColumnHAItem(keys[index], values[index])
                if (index+ 1 < data.size)
                ColumnHAItem(keys[index + 1], values[index + 1])
            }
        }
    }
}

@Composable
fun ColumnHAItem(arrangement: Alignment.Horizontal, info: String) {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier.width(150.dp).height(80.dp).background(Color(0xffEFEFEF)),
            horizontalAlignment = arrangement
        ) {
            colors.forEach {
                Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(it))
            }
        }
        Text(text = info, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(5.dp))
    }
}
"""

const val ColumnNode2Info =
"""【horizontalAlignment】 : 水平对齐  【Alignment.Horizontal】"""

const val ColumnNode3Code =
"""@Composable
fun ColumnNode3() {
    val colors = arrayOf(Color.Red, Color.Blue, Color.Green,)
    Column(
        Modifier.width(250.dp).height(100.dp).background(Color(0xffEFEFEF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[0]))
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[1]).weight(1f))
        Spacer(modifier = Modifier.width(30.dp).height(30.dp).background(colors[2]).weight(2f))
    }
}"""

const val ColumnNode3Info =
"""Modifier 的 weight 属性只能用于 Row 和 Column 中，该案例里蓝色和绿色区域高度占比 1:2，且无视盒自身高度，使 Column 区域竖向占满。"""

const val Code =
""""""

const val Info =
""""""