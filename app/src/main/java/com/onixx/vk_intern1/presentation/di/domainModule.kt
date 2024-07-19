package com.onixx.ef_testwork.di


import com.onixx.vk_intern1.domain.usecase.ConvertUseCase
import com.onixx.vk_intern1.domain.usecase.GetMoneyUnitsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<ConvertUseCase> { ConvertUseCase(get()) }

    factory<GetMoneyUnitsUseCase> { GetMoneyUnitsUseCase(get()) }

}