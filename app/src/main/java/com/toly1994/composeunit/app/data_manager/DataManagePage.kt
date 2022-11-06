package com.toly1994.composeunit.app.data_manager

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.toly1994.composeunit.layouts.counter.CountViewModel
import com.toly1994.composeunit.repository.database.LocalDb
import com.toly1994.composeunit.repository.database.entity.WidgetPo
import com.toly1994.composeunit.repository.memory.MemoryNodeDataStore
import com.toly1994.composeunit.repository.memory.MemoryWidgetDataStore
import kotlinx.coroutines.launch

@Composable
fun DataManagePage(
) {
//        val db = Room.databaseBuilder(this,ComposeUnitDB::class.java,"compose_unit").allowMainThreadQueries().build()
//        db.widgetDao().insertAll(MemoryWidgetDataStore.allWidget.first().toPo())

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text("数据库测试") }) }
    ) {
        Column(Modifier.padding(it).fillMaxWidth().fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                addWidget()
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("插入成功!")
                }
//                scaffoldState.s
            }) {
                Text(text = "添加组件数据")
            }
            Button(onClick = { addNode()
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("插入成功!")
                }
            }) {
                Text(text = "添加节点数据")
            }
        }
    }
}

private fun addWidget(){
    val dao = LocalDb.database.widgetDao();
    MemoryWidgetDataStore.allWidget.forEach(){
        dao.insertAll(it.toPo())
    }
}

//private fun findWidget(): List<WidgetPo>{
////    val dao = LocalDb.database.widgetDao();
////    return dao.queryAll()
//}

private fun addNode(){
    val dao = LocalDb.database.nodeDao();
    MemoryNodeDataStore.allNodes.forEach(){
        dao.insertAll(it)
    }

//    val dao = LocalDb.database.widgetDao();
//    dao.deleteAll()
}