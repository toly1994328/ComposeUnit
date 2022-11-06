package com.toly1994.composeunit.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.impl.MemoryWidgetRepository
import com.toly1994.composeunit.repository.WidgetRepository
import com.toly1994.composeunit.repository.impl.DbWidgetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class WidgetViewModel (
    private val repository: WidgetRepository = MemoryWidgetRepository()
//    private val repository: WidgetRepository = DbWidgetRepository()
): ViewModel() {
    // 状态数据
    private val _uiState = MutableStateFlow(WidgetModelState())
    val uiState: StateFlow<WidgetModelState> = _uiState

    init {
        loadData()
    }

    fun loadData(){
        viewModelScope.launch {
            repository.queryAllWidget()
                .catch { ex ->
                    _uiState.value = WidgetModelState(error = ex.message)
                }
                .collect { data ->
                    _uiState.value = WidgetModelState(
                        models = data
                    )
                }
        }
    }

}

data class WidgetModelState(
    val models: List<WidgetModel> = listOf(),
    val error: String? = null
)