package com.sysarcomp.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.sysarcomp.horoscapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val data: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
) {

    fun toDomain(): PredictionModel {

        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}

