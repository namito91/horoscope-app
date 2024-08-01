package com.sysarcomp.horoscapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sysarcomp.horoscapp.databinding.FragmentHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// el ciclo de vida de un fragment es distinto al de un activity
@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!! // se accede a "_binding" , atraves de "binding"

    // es necesario tener un metodo, para cuando la vista ya ha sido cargada!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }


    private fun initUI() {

        initUIState()
    }


    private fun initUIState() {

        // se necesita enganchar el view model , a este fragment
        // esta corutina se engancha al ciclo de vida del fragment
        // es especifica para este caso
        // se destruye cuando se destruye el fragment, automaticamente
        // recomendada para fragments y activitys
        lifecycleScope.launch {

            // indica cuando se inice el ciclo de vida del fragment
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                // indica que se suscriba a los datos del view model "horoscope"
                horoscopeViewModel.horoscope.collect {

                    // cuando se modifiquen los valores de horoscope.value , -> _horoscope.value = listOf(
                    //                                                                  HoroscopeInfo.Aries, HoroscopeInfo.Gemini, HoroscopeInfo.Taurus
                    //                                                             )
                    // va a ejecutarse este trozo de codigo
                    Log.i("Patrox", it.toString()) // it es la lista que esta en horoscope
                }
            }
        }

    }


    // este metodo crea la vista del fragment
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}