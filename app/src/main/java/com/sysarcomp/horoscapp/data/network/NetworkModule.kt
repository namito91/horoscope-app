package com.sysarcomp.horoscapp.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
* La combinación de @Module y @InstallIn(SingletonComponent::class) en Hilt
*  configura un módulo que proporciona dependencias accesibles en toda la aplicación
* con un ciclo de vida singleton. Esto es útil para instancias como clientes HTTP y servicios de API,
* que deben ser únicos y estar disponibles globalmente. Hilt simplifica enormemente la configuración
* y el uso de la inyección de dependencias en las aplicaciones Android.
*
* */


@Module
@InstallIn(SingletonComponent::class) // esto hace el module accesible para todos los archivos de la app
object NetworkModule {


    //Provisión de Retrofit: El método provideRetrofit proporciona una instancia(objeto) de Retrofit,
    // configurada con una URL base y un cliente HTTP.
    // esto nos permite inyectar el objeto retrofir donde queramos
    @Provides
    @Singleton // hacemos el objeto singleton
    fun provideRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()) // añadimos gson para la conversion de json a objetos
            .build() // creamos el objeto de retrofit
    }


    // Dagger hilt provee un objeto de retrofit aqui
    //
    @Provides
    fun provideHoroscopeApiServide(retrofit: Retrofit): HoroscopeApiService {

        return retrofit.create(HoroscopeApiService::class.java)
    }
}