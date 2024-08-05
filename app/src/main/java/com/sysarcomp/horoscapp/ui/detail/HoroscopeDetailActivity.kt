package com.sysarcomp.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.navigation.navArgs
import com.sysarcomp.horoscapp.R
import com.sysarcomp.horoscapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

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
    }
}