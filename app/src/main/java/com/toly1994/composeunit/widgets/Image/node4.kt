package com.toly1994.composeunit.widgets.Image

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toly1994.composeunit.R

// "widgetId": 2,
// "name": "颜色叠合模式",
// "subtitle":
//     【colorFilter】 : 缩放模式  【ColorFilter】

@SuppressLint("SuspiciousIndentation")
@Composable
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
}

@Preview
@Composable
fun ImageNode4Preview() {
    ImageNode4()
}