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
            buttonEKeys.setOnClickListener {
                navigateToEKeys()
            }

            buttonPassCodes.setOnClickListener {
                navigateToPassCodes()
            }

            buttonCards.setOnClickListener {
                navigateToCards()
            }

            buttonFingerPrints.setOnClickListener {
                navigateToFingerPrints()
            }

            buttonRemotes.setOnClickListener {
                navigateToRemotes()
            }

            buttonAuthorizedAdmins.setOnClickListener {
                navigateToAdminAuthorizes()
            }

            buttonRecords.setOnClickListener {
                navigateToRecords()
            }

            buttonSettings.setOnClickListener {
                navigateToSettings()
            }
        }
    }

    private fun navigateToEKeys() {
        val action = ManagerLockFragmentDirections.actionManagerLockFragmentToEKeysFragment()
        findNavController().navigate(action)
    }

    private fun navigateToPassCodes() {
        val action = ManagerLockFragmentDirections.actionManagerLockFragmentToPassCodesFragment()
        findNavController().navigate(action)
    }

    private fun navigateToCards() {
        val action = ManagerLockFragmentDirections.actionManagerLockFragmentToCardsFragment()
        findNavController().navigate(action)
    }

    private fun navigateToFingerPrints() {
        val action = ManagerLockFragmentDirections.actionManagerLockFragmentToFingerPrintsFragment()
        findNavController().navigate(action)
    }

    private fun navigateToRemotes() {
        val action = ManagerLockFragmentDirections.actionManagerLockFragmentToRemotesFragment()
        findNavController().navigate(action)
    }

    private fun navigateToAdminAuthorizes() {
        val action =
            ManagerLockFragmentDirections.actionManagerLockFragmentToAdminAuthorizesFragment()
        findNavController().navigate(action)
    }

    private fun navigateToRecords() {
        val action = ManagerLockFragmentDirections.actionManagerLockFragmentToRecordsFragment()
        findNavController().navigate(action)
    }

    private fun navigateToSettings() {
        val action =
            ManagerLockFragmentDirections.actionManagerLockFragmentToSettingsFragment()
        findNavController().navigate(action)
    }
}