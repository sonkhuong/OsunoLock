package com.dagoras.osunolock.manager_lock.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dagoras.osunolock.databinding.FragmentManagerLockBinding
import com.dagoras.osunolock.model.Lock
import com.dagoras.osunolock.model.LockManager

class ManagerLockFragment : Fragment() {

    private val args: ManagerLockFragmentArgs by navArgs()
    private lateinit var binding: FragmentManagerLockBinding

    private var lock: Lock? = null
    private var lockManager: LockManager? = null

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
        setupLayout()
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

    private fun setupLayout() {
        lock = args.lock
        lockManager = args.lockManager
        with(binding) {
            viewToolbarLock.textLockName.text = lock?.lockName
            viewToolbarLock.textBattery.text = lock?.batteryLock.toString()
            if (lockManager?.typeManager == 1) {
                buttonAuthorizedAdmins.isVisible = false
            } else if (lockManager?.typeManager == 2) {
                buttonEKeys.isVisible = false
                buttonPassCodes.isVisible = false
                buttonCards.isVisible = false
                buttonRemotes.isVisible = false
                buttonAuthorizedAdmins.isVisible = false
                buttonSettings.isVisible = false
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