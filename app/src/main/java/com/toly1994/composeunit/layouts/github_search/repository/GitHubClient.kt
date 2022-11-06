package com.toly1994.composeunit.layouts.github_search.repository

import com.toly1994.composeunit.layouts.github_search.repository.GitHubApi.searchUserRepo
import com.toly1994.composeunit.layouts.github_search.repository.models.GithubRepo
import retrofit2.http.GET
import retrofit2.http.Path

object GitHubApi {
    val baseUrl = "https://api.github.com/"
    const val searchUserRepo = "users/{username}/repos"
}

interface GitHubClient {

    @GET(searchUserRepo)
    suspend fun getRepositoryByUser(@Path("username") username: String): List<GithubRepo>

}