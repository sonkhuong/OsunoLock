package com.dagoras.osunolock.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.FragmentLoginBinding
import com.dagoras.osunolock.splash.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            layoutLogin.visibility = View.VISIBLE
            val background: Thread = object : Thread() {
                override fun run() {
                    try {
                        layoutLogin.startAnimation(
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

            var i = 0
            buttonLogin.setOnClickListener {
                navigateToMainActivity()
            }

            urlSignupAccount.setOnClickListener {
                navigateToSignUpFragment()
            }
        }
    }

    private fun navigateToMainActivity() {
        val action = LoginFragmentDirections.actionLoginFragmentToMainActivity()
        findNavController().navigate(action)
    }

    private fun navigateToSignUpFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
        findNavController().navigate(action)
    }
}