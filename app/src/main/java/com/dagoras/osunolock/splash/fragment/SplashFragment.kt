package com.dagoras.osunolock.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {

            val background: Thread = object : Thread() {
                override fun run() {
                    try {
                        logoSplash.startAnimation(
                            AnimationUtils.loadAnimation(
                                context,
                                R.anim.anim_splash_to_login
                            )
                        )
                        sleep(3500L)
                        navigateToLogin()
                    } catch (e: Exception) {
                    }
                }
            }
            background.start()
        }
    }

    private fun navigateToLogin() {
        val action = SplashFragmentDirections.actionSplashFragmentToLoginFragment()
        findNavController().navigate(action)
    }
}