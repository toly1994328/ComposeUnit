package com.toly1994.composeunit.repository.memory.node_res

const val textNode1Code =
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

const val textNode1Info =
"""【text】 : 文字  【String】
【style】: 文字样式   【TextStyle】
【color】: 文字颜色   【Color】
【fontSize】: 文字大小   【TextUnit】
【fontWeight】: 字重   【FontWeight?】
【fontStyle】: 字体样式   【FontStyle?】
【letterSpacing】: 字距   【TextUnit】"""

const val textNode2Code =
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

const val textNode2Info =
"""【backgroundColor】 : 背景颜色  【Color】
【shadow】: 阴影   【Shadow】"""

const val textNode3Code =
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

const val textNode3Info =
    """【textDecoration】 : 文字装饰  【TextDecoration】
【textIndent】: 文字缩进   【textIndent】"""


const val textNode4Code =
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

const val textNode4Info =
    """【softWrap】 : 是否自动换行  【Boolean】
【overflow】: 溢出方式   【TextOverflow】
【maxLines】: 最大行数   【Int】"""


const val textNode5Code = "@Composable\n" +
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

const val textNode5Info =
    """【textAlign】: 文字对齐   【TextAlign?】
【lineHeight】 : 行高  【TextUnit】"""