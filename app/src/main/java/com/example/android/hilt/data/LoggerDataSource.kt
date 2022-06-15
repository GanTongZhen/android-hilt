package com.example.android.hilt.data

/**
 * LoggerDataSource
 *
 * Created by GANTZ on 2022/6/14
 * Copyright (c) 2022 Heyooh Technology Co.,Ltd. All rights reserved.
 *
 */
interface LoggerDataSource {
    fun addLog(msg: String)
    fun getAllLogs(callback: (List<Log>) -> Unit)
    fun removeLogs()
}