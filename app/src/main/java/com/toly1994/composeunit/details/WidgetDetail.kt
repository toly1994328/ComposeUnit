package com.toly1994.composeunit.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R
import com.toly1994.composeunit.app.utils.CodeHighlighter
import com.toly1994.composeunit.components.style.Gap
import com.toly1994.composeunit.components.tolyui.Panel
import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.memory.MemoryNodeDataStore
import com.toly1994.composeunit.repository.memory.MemoryWidgetDataStore
import com.toly1994.composeunit.widgets.WidgetNodeMap


@Composable
fun WidgetDetail(
    widgetId: Int?,
    widgetName: String?,
    onShare: (String) -> Unit,
    back: () -> Unit,
) {

    val model = MemoryWidgetDataStore.allWidget
        .find { it.id == widgetId } ?: return

  val nodes = MemoryNodeDataStore.allNodes.filter { it.widgetId==widgetId }
    Column {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = back) {
                    Icon(
                        Icons.Default.ArrowBack, "",
                    )
                }
            },
            title = {
                Text(text = model.name)
            },
            actions = {
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = "id : ${model.id}"
                )
            }
        )
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            item {
                NodeWidgetPanel(model)
                Gap(height = 10f)
            }
            items(nodes.size) { index ->
                NodeItem(nodes[index], index= index, onShare = onShare)
            }
//            nodes.forEach(){
//
//            }

        }
    }
}

@Composable
fun NodeWidgetPanel(model: WidgetModel) {
    var starText = "";
    for (i in 0 until model.lever) {
        starText += "★"
    }
    val starTextStyle = TextStyle(
        color = MaterialTheme.colors.primary,
    )
    Column {
        Text(
            modifier = Modifier.padding(start = 15.dp, top = 10.dp),
            text = model.nameCN,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.weight(1f)) {
                Panel {
                    Text(
                        text = model.info
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .width(130.dp)
                        .padding(end = 10.dp)
                        .aspectRatio(56 / 32f)
                        .clip(
                            RoundedCornerShape(5.dp)
                        ),
                    painter = painterResource(id = R.mipmap.anim_draw), contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Gap(height = 4f)
                Text(text = starText, style = starTextStyle)
            }

        }
        Gap(height = 10f)
        Divider()
    }
}

@Composable
fun NodeItem(model: NodeModel,index:Int, onShare: (String) -> Unit?) {
//    val expend: MutableState<Boolean> = remember { mutableStateOf(false) }
    val expend: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) }
    Column {
        NodeTitle(name = model.name,
            expend = expend.value,
            onClick = {
                expend.value = !expend.value
            },
            onShare = {
                onShare(model.code)
            })
        if (expend.value) {
            Panel { CodeHighlighter(code = model.code) }
        } else {
            Gap(height = 10f)
        }

        WidgetNodeMap(model.widgetId, index)
        Panel { Text(text = model.info) }
        Divider()
        Gap(height = 10f)
    }
}

@Composable
private fun NodeTitle(
    expend: Boolean,
    name: String, onClick: () -> Unit,
    onShare: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Gap(width = 18f)
        Spacer(
            modifier = Modifier
                .width(12.dp)
                .height(12.dp)
                .shadow(2.dp, CircleShape)
                .background(MaterialTheme.colors.primary)
        )
        Gap(width = 10f)
        Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.mipmap.icon_share),
            "",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(22.dp, 22.dp)
                .clickable(
                    onClick = { onShare() },
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }),
        )
        Icon(
            painter = painterResource(id = R.mipmap.icon_code),
            "",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(start = 5.dp, end = 15.dp)
                .size(30.dp, 30.dp)
                .rotate(if (expend) 90f else 0f)
                .clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }),
        )
    }
}



