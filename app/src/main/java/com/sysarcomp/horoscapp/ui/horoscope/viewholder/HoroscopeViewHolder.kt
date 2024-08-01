package com.sysarcomp.horoscapp.ui.horoscope.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sysarcomp.horoscapp.databinding.ItemHoroscopeBinding
import com.sysarcomp.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)


    fun render(horoscopeInfo: HoroscopeInfo) {

        // cargamos la vista , con los datos en la sealed class HoroscopeInfo (es el modelo)
        val context = binding.tvTitle.context

        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
    }

}