//package com.toly1994.composeunit.models.state
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import com.toly1994.composeunit.models.WidgetModel
//import com.toly1994.composeunit.repository.WidgetRepository
//import kotlinx.coroutines.flow.Flow
//
//
//class WidgetSearchState {
//    var result: List<WidgetModel> by mutableStateOf(listOf())
//}
//
//class WidgetViewModel(
//    private val repository:WidgetRepository,
//    private val savedState:SavedStateHandle
//):ViewModel(){
//
////    val uiState :State<WidgetSearchState>
//    val widgets:Flow<List<WidgetModel>> = repository.getAllWidget()
//}