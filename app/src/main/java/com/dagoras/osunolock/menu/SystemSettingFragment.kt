package com.dagoras.osunolock.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagoras.osunolock.databinding.FragmentSystemSettingBinding

class SystemSettingFragment : Fragment() {

    private lateinit var binding: FragmentSystemSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSystemSettingBinding.inflate(inflater, container, false)
        return binding.root
    }
}