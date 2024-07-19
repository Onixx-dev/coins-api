package com.onixx.vk_intern1.data.repositoryImpl

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.onixx.vk_intern1.data.retrofit.RetrofitExchange
import com.onixx.vk_intern1.domain.model.ExchangeRatesModel
import com.onixx.vk_intern1.domain.model.MoneyUnit
import com.onixx.vk_intern1.domain.model.MoneyUnitModel
import com.onixx.vk_intern1.domain.repository.ExchangeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ExchangeRepositoryImpl : ExchangeRepository {

    override suspend fun getMoneyUnits(currency: String): MoneyUnitModel {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.freecurrencyapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(RetrofitExchange::class.java)

        val result = retrofit
            .getMoneyUnits(
                key = "fca_live_0MH6hmR9K6d3MK3zTMf7mj0IkJoCbtl8XdvTwywp",
                currency = currency
            )
            .await()

        return result.body() ?: MoneyUnitModel(HashMap<String, MoneyUnit>())
    }


    override suspend fun getExchange(base: String, currency: String): ExchangeRatesModel {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.freecurrencyapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(RetrofitExchange::class.java)

        val result = retrofit
            .getExchange(
                key = "fca_live_0MH6hmR9K6d3MK3zTMf7mj0IkJoCbtl8XdvTwywp",
                base = base,
                currency = currency
            )
            .await()

        return result.body() ?: ExchangeRatesModel(HashMap<String, Double>())

    }
}