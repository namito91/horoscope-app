package com.sysarcomp.horoscapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// primer clase que se ejecuta del proyecto , (clase raiz)
@HiltAndroidApp // se inicializa dagger hilt en el proyecto!
class HoroscApp : Application()