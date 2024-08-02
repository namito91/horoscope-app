package com.sysarcomp.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sysarcomp.horoscapp.R
import com.sysarcomp.horoscapp.domain.model.HoroscopeInfo
import com.sysarcomp.horoscapp.ui.horoscope.viewholder.HoroscopeViewHolder

// HoroscopeInfo es el modelo de datos !

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected: (HoroscopeInfo) -> Unit // le pasamos una lambda , para cuando el usuario seleccione un item de signo
) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list: List<HoroscopeInfo>) {

        horoscopeList = list

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {

        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }


    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {

        holder.render(horoscopeList[position], onItemSelected)
    }


    override fun getItemCount() = horoscopeList.size
}