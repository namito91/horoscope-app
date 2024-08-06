package com.sysarcomp.horoscapp.ui.detail

// se debe crear esta clase, para manejar los estados de la vista !
sealed class HoroscopeDetailState {

    data object Loading : HoroscopeDetailState() // los data object no llevan argumento
    data class Error(val error: String) : HoroscopeDetailState() // los data class llevan argumento
    data class Success(val data: String) : HoroscopeDetailState()
}