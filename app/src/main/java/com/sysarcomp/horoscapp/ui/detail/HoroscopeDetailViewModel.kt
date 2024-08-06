package com.sysarcomp.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

/*
*  Los ViewModels están diseñados para gestionar
* y almacenar datos de la interfaz de usuario (UI) de manera más eficiente
* y para sobrevivir a los cambios de configuración, como la rotación de la pantalla.
*
* */

/*
* MutableStateFlow es una herramienta poderosa para manejar el estado de manera reactiva
* en aplicaciones Android utilizando Kotlin. Es especialmente útil en la arquitectura MVVM,
* donde el ViewModel expone el estado a la UI y reacciona a eventos de forma eficiente y segura.
*
* */


@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor() : ViewModel() {

    // seteamos el estado inicial , como un loading
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)

    val state: MutableStateFlow<HoroscopeDetailState> = _state


}