package com.sysarcomp.horoscapp.data.providers.network.response

import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val data: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
)

