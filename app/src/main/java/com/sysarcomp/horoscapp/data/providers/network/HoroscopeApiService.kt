package com.sysarcomp.horoscapp.data.providers.network

import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String) {

        
    }
}