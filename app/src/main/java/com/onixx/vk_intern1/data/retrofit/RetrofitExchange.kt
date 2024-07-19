package com.onixx.vk_intern1.data.retrofit

import com.onixx.vk_intern1.domain.model.ExchangeRatesModel
import com.onixx.vk_intern1.domain.model.MoneyUnitModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitExchange {

    @GET("latest")
    fun getExchange(
        @Query("apikey") key : String,
        @Query("base_currency") base : String,
        @Query("currencies") currency: String
    ) : Deferred<Response<ExchangeRatesModel>>

    @GET("currencies")
    fun getMoneyUnits(
        @Query("apikey") key : String,
        @Query("currencies") currency: String
    ) : Deferred<Response<MoneyUnitModel>>

}