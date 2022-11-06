package com.toly1994.composeunit.layouts.github_search.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.toly1994.composeunit.R
import com.toly1994.composeunit.components.style.Gap

@Composable
fun GithubSearchBar(onSearch: (String) -> Unit, ) {
    val input: MutableState<String> = remember { mutableStateOf("") }
    TopAppBar {
        Gap(width = 10f)
        Image(
            modifier = Modifier.width(36.dp).height(36.dp)
                .border(1.dp, Color.White, CircleShape)
                .shadow(elevation = 1.dp, shape = CircleShape),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.mipmap.icon_head),
            contentDescription = "",
        )
        Gap(width = 10f)
        RoundTextField(
            modifier = Modifier.weight(1f),
            text = input.value,
            onValueChange = {
                input.value= it
                if(it.isEmpty()){ onSearch(it) }
            }
        )
        TextButton( onClick = { onSearch(input.value) }) {
            Text("搜索",color= Color.White)
        }
    }
}


@Composable
fun RoundTextField(
    text: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    hint: String = "请输入用户名...",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    cursorBrush: Brush = SolidColor(MaterialTheme.colors.primary)
) {
    // 焦点状态
    var hasFocus by remember { mutableStateOf(false) }
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier.clip(CircleShape).background(Color.White)
            .onFocusChanged { hasFocus = it.isFocused },
        singleLine = true,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        cursorBrush = cursorBrush,
        decorationBox = @Composable { innerTextField ->
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Gap(width = 15f)
                Box(modifier = Modifier.weight(1f)){
                    // hint
                    if(text.isEmpty()){
                        Text(text = hint, style = textStyle.copy(Color.Gray))
                    }
                    innerTextField()
                }
                // 显示 x
                if(hasFocus && text.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Filled.Clear, // 清除图标
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.width(20.dp).height(20.dp)
                            .clickable(
                                onClick = {onValueChange("")},
                                indication = null,
                                interactionSource = remember {
                                    MutableInteractionSource()
                                }),
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    )
}
