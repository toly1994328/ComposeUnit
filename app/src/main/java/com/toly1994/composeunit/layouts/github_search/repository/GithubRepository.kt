package com.toly1994.composeunit.layouts.github_search.repository

import com.toly1994.composeunit.layouts.github_search.repository.models.GithubRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GithubRepository {

    private val retorfit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(GitHubApi.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val gitHubClient = retorfit.create<GitHubClient>()

    suspend fun getRepositoryByUser(username: String = "toly1994328"): Flow<List<GithubRepo>> =
        flow {
            val data = gitHubClient.getRepositoryByUser(username)
            emit(data)
        }

}