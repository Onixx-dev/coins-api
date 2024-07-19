package com.onixx.ef_testwork.di


import com.onixx.vk_intern1.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> { MainViewModel(get(), get()) }

}