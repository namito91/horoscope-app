package com.sysarcomp.horoscapp.data

import android.util.Log
import com.sysarcomp.horoscapp.data.network.HoroscopeApiService
import com.sysarcomp.horoscapp.domain.Repository
import com.sysarcomp.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

// implementamos en la capa de data, la interfaz Repository en la capa domain
// necesitamos unir retrofit al horoscopeApiService , y por eso lo inyectamos aqui
// esto nos permite hacer peticios de internet desde este repositorio
class RepositoryImpl @Inject constructor(private val horoscopeApiService: HoroscopeApiService) :
    Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {

        /*
        * En Kotlin, la función runCatching se utiliza para ejecutar un bloque de código
        * y encapsular su resultado en un objeto Result.
        * Este objeto puede contener el resultado exitoso del bloque de código
        * o una excepción si ocurre un error.
        * Esta funcionalidad es muy útil para manejar errores de manera concisa y clara,
        * sin necesidad de usar bloques try-catch explícitos.
        * */
        runCatching { horoscopeApiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() } // si la peticion a la api fue exitosa , se ejecuta esto
            .onFailure { Log.i("Patrox", "error ${it.message}") } // sino , se ejecuta esto

        return null
    }


}