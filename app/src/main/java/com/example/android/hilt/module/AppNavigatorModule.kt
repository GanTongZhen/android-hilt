package com.example.android.hilt.module

import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * AppNavigatorModule
 *
 * Created by GANTZ on 2022/6/14
 * Copyright (c) 2022 Heyooh Technology Co.,Ltd. All rights reserved.
 *
 */

@InstallIn(ActivityComponent::class)
@Module
abstract class AppNavigatorModule {
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}