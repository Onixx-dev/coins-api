package com.onixx.vk_intern1.domain.usecase

import com.onixx.vk_intern1.domain.model.ExchangeRatesModel
import com.onixx.vk_intern1.domain.repository.ExchangeRepository

class ConvertUseCase (private val exchangeRepository: ExchangeRepository)   {

    suspend fun execute(base : String, currents : String) : ExchangeRatesModel {
        val result = exchangeRepository.getExchange(base, currents)
        return result
    }

}