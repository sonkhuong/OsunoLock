package com.dagoras.osunolock.managerlock.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.databinding.FragmentManagerLockBinding

class ManagerLockFragment : Fragment() {

    private lateinit var binding: FragmentManagerLockBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManagerLockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            buttonSettings.setOnClickListener {
                navigateToSettings()
            }
            buttonRemote
        }
    }

    private fun navigateToSettings() {
        val action =
            ManagerLockFragmentDirections.actionManagerLockFragmentToSettingsFragment()
        findNavController().navigate(action)
    }
}