package com.example.android.hilt.data

import dagger.hilt.android.scopes.ActivityScoped
import java.util.*
import javax.inject.Inject

/**
 * LoggerInMemoryDataSource
 *
 * Created by GANTZ on 2022/6/14
 * Copyright (c) 2022 Heyooh Technology Co.,Ltd. All rights reserved.
 *
 */

@ActivityScoped
class LoggerInMemoryDataSource @Inject constructor() : LoggerDataSource {
    private val logs = LinkedList<Log>()

    override fun addLog(msg: String) {
        logs.add(Log(msg = msg, System.currentTimeMillis()))
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback.invoke(logs)
    }

    override fun removeLogs() {
        logs.clear()
    }
}