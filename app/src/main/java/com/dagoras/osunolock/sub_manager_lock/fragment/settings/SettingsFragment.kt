package com.dagoras.osunolock.sub_manager_lock.fragment.settings

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
            lineInformation.setOnClickListener {
                navigateToLockInformation()
            }

            lineAutoLock.setOnClickListener {
                navigateToAutoLock()
            }

            lineLockSound.setOnClickListener {
                navigateToLockSound()
            }

            lineTamperAlert.setOnClickListener {
                navigateToTamperAlert()
            }

            lineDiagnosis.setOnClickListener {
                navigateToDiagnosis()
            }

            lineResetButton.setOnClickListener {
                navigateToResetButton()
            }

            lineUploadData.setOnClickListener {
                navigateToUploadData()
            }

            lineRemote.setOnClickListener {
                navigateToRemoteUnlock()
            }
        }
    }

    private fun navigateToRemoteUnlock() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToRemoteUnlockFragment()
        findNavController().navigate(action)
    }

    private fun navigateToLockInformation() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToLockInformationFragment()
        findNavController().navigate(action)
    }

    private fun navigateToTamperAlert() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToTamperAlertFragment()
        findNavController().navigate(action)
    }

    private fun navigateToAutoLock() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToAutoLockFragment()
        findNavController().navigate(action)
    }

    private fun navigateToDiagnosis() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToDiagnosisFragment()
        findNavController().navigate(action)
    }

    private fun navigateToResetButton() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToResetButtonFragment()
        findNavController().navigate(action)
    }

    private fun navigateToLockSound() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToLockSoundFragment()
        findNavController().navigate(action)
    }

    private fun navigateToUploadData() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToUploadDataFragment()
        findNavController().navigate(action)
    }
}