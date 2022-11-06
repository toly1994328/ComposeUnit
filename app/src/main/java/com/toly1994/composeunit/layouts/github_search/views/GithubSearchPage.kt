package com.toly1994.composeunit.layouts.github_search.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toly1994.composeunit.layouts.github_search.repository.models.GithubRepo
import com.toly1994.composeunit.layouts.github_search.view_model.GithubRepoUIState
import com.toly1994.composeunit.layouts.github_search.view_model.GithubSearchViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GithubSearchPage(
    viewModel: GithubSearchViewModel = viewModel()
) {
    val state = viewModel.uiState.collectAsState().value
    Scaffold(
        topBar = {
            GithubSearchBar() {
                viewModel.searchRepositoryByUserName(it)
            }
        }
    ) {
        if(state is GithubRepoUIState.Loading){
            SimpleInfo(text = "Loading...")
        }
        if(state is GithubRepoUIState.Error){
            SimpleInfo(text = "Error")
        }
        if(state is GithubRepoUIState.Init){
            SimpleInfo(text = "请输入查询参数")
        }
        if(state is GithubRepoUIState.Fill){
            HomeLazyGithubRepoList(
                state.repos
            )
        }
    }
}

@Composable
fun SimpleInfo(text:String){
    Box(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun HomeLazyGithubRepoList(
    data: List<GithubRepo>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp)
    ) {
        itemsIndexed(data) { _, item ->
            GithubRepoItem(item)
        }
    }
}


