package com.toly1994.composeunit.repository.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.toly1994.composeunit.models.NodeModel
import com.toly1994.composeunit.repository.database.dao.NodeDao
import com.toly1994.composeunit.repository.database.dao.WidgetDao
import com.toly1994.composeunit.repository.database.entity.WidgetPo
import java.io.File

object LocalDb{
    // 数据库名
    private const val dbName: String = "compose_unit.db"

    lateinit var database: ComposeUnitDB
        private set

    fun offer(context: Context) {
        database = Room.databaseBuilder(context, ComposeUnitDB::class.java, dbName)
            .allowMainThreadQueries() //允许在主线程操作
            .addCallback(DbCreateCallBack) // 回调监听
//            .addMigrations()// 数据库升级
            .build()
    }

    private object DbCreateCallBack : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            Log.e("LocalDb", "onOpen: " + db.version)
        }

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.e("LocalDb", "first onCreate db version: " + db.version)
        }
    }
}

@Database(entities = [WidgetPo::class,NodeModel::class], version = 1, exportSchema = false)
abstract class ComposeUnitDB : RoomDatabase() {
    abstract fun widgetDao(): WidgetDao
    abstract fun nodeDao(): NodeDao
}