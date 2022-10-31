package com.toly1994.composeunit.doing

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Doing(
    modifier: Modifier = Modifier,
    name:String
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            Icons.Outlined.Build, "",
            tint = Color(0xffC5C5C5),
            modifier = Modifier.size(80.dp,80.dp))
        Text(
            modifier = Modifier.padding(12.dp),
            text = name,
            style =  TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xff5A576C),
            ),
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "功能正在开发之中，敬请期待...",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            color =  Color(0xffC5C5C5)
        )
    }
}

@Preview
@Composable
fun ComingSoonPreview() {
    Doing(name="布局集录")
}
