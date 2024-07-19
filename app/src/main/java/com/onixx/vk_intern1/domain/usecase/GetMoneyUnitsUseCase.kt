package com.onixx.vk_intern1.domain.usecase

import com.onixx.vk_intern1.domain.model.MoneyUnit
import com.onixx.vk_intern1.domain.model.MoneyUnitModel
import com.onixx.vk_intern1.domain.repository.ExchangeRepository

class GetMoneyUnitsUseCase (private val exchangeRepository: ExchangeRepository)   {

    suspend fun execute(currents : String) : MoneyUnitModel {
        val result = exchangeRepository.getMoneyUnits(currents)
        return result
    }

}