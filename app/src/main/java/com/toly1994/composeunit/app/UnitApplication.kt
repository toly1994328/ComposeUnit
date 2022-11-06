package com.toly1994.composeunit.app

import android.app.Application
import com.toly1994.composeunit.repository.database.LocalDb

class UnitApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        LocalDb.offer(this)
    }
}