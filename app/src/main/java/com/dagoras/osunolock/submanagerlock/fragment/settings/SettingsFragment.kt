package com.dagoras.osunolock.submanagerlock.fragment.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            lineRemote.setOnClickListener {
                navigateToRemoteUnlock()
            }
        }
    }

    private fun navigateToRemoteUnlock() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToRemoteUnlockFragment()
        findNavController().navigate(action)
    }
}