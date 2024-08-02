package com.sysarcomp.horoscapp.data.providers

import com.sysarcomp.horoscapp.domain.model.HoroscopeInfo
import com.sysarcomp.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

// la capa de data , solo provee datos


class HoroscopeProviders @Inject constructor() {

    fun getHoroscopes(): List<HoroscopeInfo> {

        return listOf(

            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}