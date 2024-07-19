package com.onixx.vk_intern1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onixx.vk_intern1.domain.model.ExchangeRatesModel
import com.onixx.vk_intern1.domain.model.MoneyUnit
import com.onixx.vk_intern1.domain.model.MoneyUnitModel
import com.onixx.vk_intern1.domain.usecase.ConvertUseCase
import com.onixx.vk_intern1.domain.usecase.GetMoneyUnitsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getMoneyUnitsUseCase : GetMoneyUnitsUseCase,
    private val convertUseCase: ConvertUseCase
) : ViewModel()  {


    private val liveMoneyUnits = MutableLiveData<MoneyUnitModel>().apply { }
    val moneyUnits: LiveData<MoneyUnitModel> = liveMoneyUnits

    val exchangeModifier = MutableLiveData<Double>().apply { 1.0 }

    lateinit var exchangeRatesModel : ExchangeRatesModel

    var inputValue : Double = 0.0
    var outputValue : Double = 0.0

    var base : String = ""
    var currense : String = ""

    init {
        getMoneyUnits()
    }




    fun getMoneyUnits(currense : String = "") {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                liveMoneyUnits.postValue(getMoneyUnitsUseCase.execute(currense))
            }
        }
    }


    fun convert(base : String = this.base, currense : String = this.currense) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if( liveMoneyUnits.value!!.data.containsKey(base) && liveMoneyUnits.value!!.data.containsKey(currense) ) {
                    exchangeRatesModel = convertUseCase.execute(base, currense)
                    if (exchangeRatesModel.data.containsKey(currense)) {
                        outputValue = inputValue * exchangeRatesModel.data[currense]!!
                        exchangeModifier.postValue(exchangeRatesModel.data[currense]!!)
                    }
                }
            }
        }
    }

    fun isExchangeRatesModelInit() : Boolean {
        return this::exchangeRatesModel.isInitialized
    }


}