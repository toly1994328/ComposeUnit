package com.toly1994.composeunit.layouts.github_search.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.toly1994.composeunit.R
import com.toly1994.composeunit.components.style.Gap
import com.toly1994.composeunit.layouts.Wrapper
import com.toly1994.composeunit.layouts.github_search.repository.models.GithubRepo
import com.toly1994.composeunit.layouts.wechat_item.CircleNumTip
import com.toly1994.composeunit.widgets.Box.BoxNode2

@Composable
fun GithubRepoItem(githubRepo: GithubRepo) {
    val titleTextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xff2F3032),
    )
    val collectTextStyle = TextStyle(
        fontSize = 10.sp,
        color = MaterialTheme.colors.primary,
        shadow = Shadow(
            color = Color.White,
            blurRadius = 2.0f,
            offset = Offset(1f, 1f)
        )
    )
    val subTextStyle = TextStyle(
        fontSize = 12.sp,
        color = Color(0xffC5C5C5),
    )

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier.padding(10.dp, 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    contentAlignment = BiasAlignment(1.2f, -1.2f)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .width(45.dp)
                            .clip(RoundedCornerShape(10)),
                        model = githubRepo.owner.avatar_url,
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(text = githubRepo.name, style = titleTextStyle)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = githubRepo.description, style = subTextStyle)
                }
                Row {
                    Wrapper(wrapperColor = Color(0xffF3F3F5)) {
                        Text(text = "star : ${githubRepo.stargazers_count}", style = collectTextStyle)
                    }
                    Gap(width = 6f)
                    Wrapper(wrapperColor = Color(0xffF3F3F5)) {
                        Text(text = "forks : ${githubRepo.forks_count}", style = collectTextStyle)
                    }
                }
            }
        }
        Divider(
            startIndent = 70.dp,
            thickness = 0.5.dp
        )
    }

}

