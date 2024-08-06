package com.sysarcomp.horoscapp.domain

// usamos esta interfaz, para comunicar la capa de data, con
// la capa de dominio

interface Repository {

    suspend fun getPrediction(sign: String)
}