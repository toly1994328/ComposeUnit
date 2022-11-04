package com.toly1994.composeunit.repository.database

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.toly1994.composeunit.repository.database.dao.WidgetDao
import com.toly1994.composeunit.repository.database.entity.WidgetPo

//object LocalDb{
//    //数据库名
//    private const val dbName: String = "zroom"
//
//    //懒加载创建数据库
//    val db: ComposeUnitDB by lazy {
//        Room.databaseBuilder(
//            App.app.applicationContext, ComposeUnitDB::class.java, dbName
//        ).allowMainThreadQueries()//允许在主线程操作
//            .addCallback(DbCreateCallBack)//增加回调监听
//            .addMigrations()//增加数据库迁移
//            .build()
//    }
//
//    private object DbCreateCallBack : RoomDatabase.Callback() {
//        //第一次创建数据库时调用
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//            Log.e("LocalDb", "first onCreate db version: " + db.version)
//        }
//    }
//}

@Database(entities = [WidgetPo::class], version = 1, exportSchema = false)
abstract class ComposeUnitDB : RoomDatabase() {
    abstract fun widgetDao(): WidgetDao
}