package com.sysarcomp.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.sysarcomp.horoscapp.R
import com.sysarcomp.horoscapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    // recibimos la data desde el fragment y xml
    private val args: HoroscopeDetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        args.type

        initUI()
    }


    private fun initUI() {

        initUIState()
    }


    private fun initUIState() {

        // Launches a new coroutine in the lifecycleScope
        lifecycleScope.launch {

            // Suspends until the lifecycle is at least STARTED and repeats the block
            // as long as it's in at least STARTED state
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                // Collects the state from the ViewModel
                horoscopeDetailViewModel.state.collect {

                    // Handles different states
                    when (it) {

                        is HoroscopeDetailState.Error -> errorState()

                        HoroscopeDetailState.Loading -> loadingState()

                        is HoroscopeDetailState.Success -> successState()

                    }
                }
            }
        }
    }

    private fun loadingState() {

       // binding.pb.isVisible = true
    }

    private fun errorState() {


    }

    private fun successState() {


    }
}