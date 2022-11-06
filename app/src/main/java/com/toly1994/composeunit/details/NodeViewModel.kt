package com.toly1994.composeunit.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.toly1994.composeunit.app.navigation.UnitRoute
import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.models.WidgetModel
import com.toly1994.composeunit.repository.NodeRepository
import com.toly1994.composeunit.repository.impl.DbNodeRepository
import com.toly1994.composeunit.repository.impl.MemoryNodeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class NodeViewModel(
    private val repository: NodeRepository = MemoryNodeRepository()
//    private val repository: NodeRepository = DbNodeRepository()
) : ViewModel() {
    // 状态数据
    private val _uiState = MutableStateFlow(NodeModelState())
    val uiState: StateFlow<NodeModelState> = _uiState

    fun handleEnterWidget(model: WidgetModel, topNavCtrl: NavHostController) {
        viewModelScope.launch {
            repository.queryNodeByWidgetId(model.id)
                .catch { ex ->
                    _uiState.value = NodeModelState(
                        error = ex.message,
                        widget = model
                    )
                }
                .collect { data ->
                    _uiState.value = NodeModelState(
                        widget = model,
                        nodes = data
                    )
                    topNavCtrl.navigate(UnitRoute.widgetDetail)
                }
        }
    }
}

data class NodeModelState(
    val widget: WidgetModel? = null,
    val nodes: List<NodeModel> = listOf(),
    val error: String? = null
)