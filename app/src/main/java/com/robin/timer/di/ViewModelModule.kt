package com.robin.timer.di

import com.robin.timer.ui.main.MainViewModel
import com.robin.timer.ui.timer.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { TimerViewModel() }
}