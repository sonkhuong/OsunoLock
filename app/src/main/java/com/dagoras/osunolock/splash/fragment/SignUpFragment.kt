package com.dagoras.osunolock.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            layoutSignup.visibility = View.VISIBLE
            val background: Thread = object : Thread() {
                override fun run() {
                    try {
                        layoutSignup.startAnimation(
                            AnimationUtils.loadAnimation(
                                context,
                                R.anim.anim_slide_up
                            )
                        )
                        sleep(2000L)
                    } catch (e: Exception) {
                    }
                }
            }
            background.start()

            buttonSignUp.setOnClickListener {
                navigateToLoginFragment()
            }

            urlLoginAccount.setOnClickListener {
                navigateToLoginFragment()
            }
        }
    }

    private fun navigateToLoginFragment() {
        findNavController().popBackStack()
    }
}