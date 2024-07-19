package com.onixx.vk_intern1.domain.repository

import com.onixx.vk_intern1.domain.model.ExchangeRatesModel
import com.onixx.vk_intern1.domain.model.MoneyUnit
import com.onixx.vk_intern1.domain.model.MoneyUnitModel

interface ExchangeRepository {

        suspend fun getMoneyUnits(currency : String) : MoneyUnitModel

        suspend fun getExchange(base : String, currency : String) : ExchangeRatesModel

}