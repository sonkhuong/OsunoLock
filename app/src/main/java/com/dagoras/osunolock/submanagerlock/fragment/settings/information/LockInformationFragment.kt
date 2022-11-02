package com.dagoras.osunolock.submanagerlock.fragment.settings.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagoras.osunolock.databinding.FragmentLockInformationBinding
import com.dagoras.osunolock.databinding.FragmentRemoteUnlockBinding

class LockInformationFragment : Fragment() {

    private lateinit var binding: FragmentLockInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLockInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
        }
    }
}