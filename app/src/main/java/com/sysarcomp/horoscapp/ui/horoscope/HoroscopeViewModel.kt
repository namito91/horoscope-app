package com.sysarcomp.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.sysarcomp.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    // Flow : se usa para comunicar el viewmodel con el fragment , y los cambios que se produzcan
    // en el viewmodel , el fragment lo va a recibir automaticamente
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())

    // esta "val horoscope" se usa para acceder a los datos de _horoscope , pero sin poder modificarlos !
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    // cuando se crea esta clase, se ejecuta primero este metodo
    init {

        _horoscope.value = listOf(
            HoroscopeInfo.Aries, HoroscopeInfo.Gemini, HoroscopeInfo.Taurus
        )
    }
}