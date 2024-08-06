package com.sysarcomp.horoscapp.data

import com.sysarcomp.horoscapp.domain.Repository

// implementamos en la capa de data, la interfaz Repository en la capa domain

class RepositoryImpl : Repository {

    override suspend fun getPrediction(sign: String) {
        TODO("Not yet implemented")
    }
    
}