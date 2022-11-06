package com.toly1994.composeunit.layouts.github_search.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toly1994.composeunit.layouts.github_search.repository.GithubRepository
import com.toly1994.composeunit.layouts.github_search.repository.models.GithubRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class GithubSearchViewModel(
    private val repository: GithubRepository = GithubRepository()
) : ViewModel() {

    // 状态数据
    private val _uiState = MutableStateFlow<GithubRepoUIState>(GithubRepoUIState.Init)
    val uiState: StateFlow<GithubRepoUIState> = _uiState

    fun searchRepositoryByUserName(arg: String) {
        if (arg == "") {
            _uiState.value = GithubRepoUIState.Init
            return
        }
        viewModelScope.launch {
            _uiState.value = GithubRepoUIState.Loading
            repository.getRepositoryByUser(arg)
                .catch { ex ->
                    _uiState.value = GithubRepoUIState.Error(
                        error = ex.message,
                    )
                }
                .collect { data ->
                    Log.d("RepositoryByUserName", "searchRepositoryByUserName: ${data.size}")
                    _uiState.value = GithubRepoUIState.Fill(
                        repos = data
                    )
                }
        }
    }
}

sealed class GithubRepoUIState{
    data class Fill(
        val repos: List<GithubRepo> = listOf(),
    ):GithubRepoUIState()

    object Loading : GithubRepoUIState()

    data class Error(
        val error: String? = null
    ):GithubRepoUIState()

    object Init:GithubRepoUIState()
}