package com.example.a3hm_3.ui.main.main

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.navigation.fragment.findNavController
import com.example.a3hm_3.R
import com.example.a3hm_3.ui.main.data.models.local.Pref
import java.util.logging.Handler


class SplashScreenFragment : Fragment() {


    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pref = Pref(requireContext())
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            if (pref.isIntroShown())
                navController.navigate(R.id.action_splashScreenFragment_to_mainFragment)
            else {
                navController.navigate(R.id.action_splashScreenFragment_to_onBordFragment)
            }
        }, 800)
    }
}