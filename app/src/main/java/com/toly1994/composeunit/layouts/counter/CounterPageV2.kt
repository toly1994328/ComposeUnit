package com.toly1994.composeunit.layouts.counter


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewmodel.compose.viewModel
// 计数器: V2 版 - ViewModel + Flow
// 拆分组件，明确结构

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CounterPageV2(
    title: String,
    viewModel: CountViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState();
    Scaffold(
        topBar = { TopAppBar(title = { Text(title) },) },
        floatingActionButton = {
            HomeFabV2(onClick = { viewModel.start() })
        }) {
        if (uiState.value.error != null) {
            HomeErrorContentV2(uiState.value.error!!)
        } else {
            HomeContentV2(uiState.value.count)
        }
    }
}


@Composable
fun HomeFabV2(onClick: () -> Unit) {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        content = {
            Icon(Icons.Rounded.Add, "")
        },
        onClick = onClick
    )
}

@Composable
fun HomeErrorContentV2(error: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Error: $error", style = TextStyle(
                fontSize = 18.sp,
                color = Color.Red
            )
        )
    }
}

@Composable
fun HomeContentV2(count: Int) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have pushed the button this many times:")
        Text(
            text = "$count", style = TextStyle(
                fontSize = 36.sp,
                color = Color.Gray
            )
        )
    }
}

// 视图模型
class CountViewModel(
    private val repository: CounterRepository = CounterRepository()
) : ViewModel() {
    // 状态数据
    private val _uiState = MutableStateFlow(CountState())
    val uiState: StateFlow<CountState> = _uiState


    // 事件 - 行为
    fun start() {
        viewModelScope.launch {
            repository.flowCount()
                .catch { ex ->
                    _uiState.value = CountState(error = ex.message)
                }
                .collect { count ->
                    _uiState.value = CountState(
                        count = count
                    )
                }
        }
    }

//    companion object {
//        fun provideFactory(
//            repository: CounterRepository = CounterRepository()
//        ): CountViewModel.Factory = object : CountViewModel.Factory {
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return CountViewModel( repository) as T
//            }
//        }
//    }
}

data class CountState(
    val count: Int = 0,
    val error: String? = null
)


class CounterRepository {
    fun flowCount(): Flow<Int> = flow {
        withContext(Dispatchers.IO) {
            for (i in 1..30) {
                delay(1000)
                withContext(Dispatchers.Main.immediate) {
                    emit(i)
                }
            }
        }
    }

    fun flowCountErrorTest(): Flow<Int> = flow {
        withContext(Dispatchers.IO) {
            for (i in 1..30) {
                delay(1000)
                withContext(Dispatchers.Main.immediate) {
                    if (i % 5 == 0) {
                        // 模拟网络异常
                        throw Exception("Test Exception When 5 Times")
                    } else {
                        emit(i)
                    }
                }
            }
        }
    }
}


