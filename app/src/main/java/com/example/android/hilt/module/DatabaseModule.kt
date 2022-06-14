package com.example.android.hilt.module

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * DatabaseModule
 *
 * Created by GANTZ on 2022/6/14
 * Copyright (c) 2022 Heyooh Technology Co.,Ltd. All rights reserved.
 *
 */


//@Module 会告知 Hilt 这是一个模块，而 @InstallIn 会通过指定 Hilt 组件告知 Hilt 绑定在哪些容器中可用。
@Module
//对于每个可被 Hilt 注入的 Android 类，都有一个关联的 Hilt 组件。
// 例如，Application 容器与 SingletonComponent 相关联，而 Fragment 容器与 FragmentComponent 相关联。
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    //使用 @Provides 提供实例
    //我们可以在 Hilt 模块中为函数添加 @Provides 注解，告知 Hilt 如何提供无法通过构造函数注入的类型。
    //
    //每当 Hilt 需要提供相应类型的实例时，都会执行带有 @Provides 注解的函数的函数主体。
    // 带有 @Provides 注解的函数的返回值类型会告知 Hilt 绑定的类型，即如何提供该类型的实例。函数参数是该类型的依赖项。
    @Provides
//    由于我们希望 Hilt 始终提供相同的数据库实例，因此为 @Provides provideDatabase 方法添加了 @Singleton 注解。
    @Singleton
    fun provideLogDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "logging.db"
        ).build()

    }

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao {
        return database.logDao()
    }
}