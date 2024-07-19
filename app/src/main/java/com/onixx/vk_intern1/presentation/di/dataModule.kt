package com.onixx.ef_testwork.di


import com.onixx.vk_intern1.data.repositoryImpl.ExchangeRepositoryImpl
import com.onixx.vk_intern1.domain.repository.ExchangeRepository
import org.koin.dsl.module

val dataModule = module {

    single<ExchangeRepository> { ExchangeRepositoryImpl() }

}