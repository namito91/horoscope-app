package com.sysarcomp.horoscapp.ui.horoscope.viewholder

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.sysarcomp.horoscapp.databinding.ItemHoroscopeBinding
import com.sysarcomp.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)


    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {

        // cargamos la vista , con los datos en la sealed class HoroscopeInfo (es el modelo)
        val context = binding.tvTitle.context

        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.ivHoroscope.setImageResource(horoscopeInfo.img)

        // cuando se pulsa sobre el item de signo, se ejecuta el lambda
        binding.parent.setOnClickListener {

            //onItemSelected(horoscopeInfo) // se le pasa como arg , el item seleccionado

            startRotationAnimation(
                binding.ivHoroscope,
                newLambda = { onItemSelected(horoscopeInfo) }) // le pasamos como arg, la imagen del item que queremos animar (lambda dentro de otra lambda)
        }
    }


    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {

        // se define las caracteristicas de la animacion
        view.animate().apply {

            duration = 500 // 500 milisegundos que dura la animacion
            interpolator =
                LinearInterpolator() // define la velocidad de la animacion,de principio a fin,(esta es la equilibrada)
            rotationBy(360f) // define el giro que va a dar la animacion,sobre su propio eje,
            withEndAction { newLambda() } // cuando termina la animacion, se ejecuta la lambda, que a su vez, ejecuta la lambda onItemSelected() !
            start()
        }
    }
}