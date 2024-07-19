package com.onixx.vk_intern1.domain.model

import com.google.gson.annotations.SerializedName


data class MoneyUnit  (

    @SerializedName("symbol"         ) var symbol        : String? = null,
    @SerializedName("name"           ) var name          : String? = null,
    @SerializedName("symbol_native"  ) var symbolNative  : String? = null,
    @SerializedName("decimal_digits" ) var decimalDigits : Int?    = null,
    @SerializedName("rounding"       ) var rounding      : Int?    = null,
    @SerializedName("code"           ) var code          : String? = null,
    @SerializedName("name_plural"    ) var namePlural    : String? = null,
    @SerializedName("type"           ) var type          : String? = null

)