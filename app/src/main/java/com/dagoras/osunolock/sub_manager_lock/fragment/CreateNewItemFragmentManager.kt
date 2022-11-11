package com.dagoras.osunolock.sub_manager_lock.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagoras.osunolock.adapter.CreateNewItemAdapter
import com.dagoras.osunolock.databinding.FragmentCreateNewItemManagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class CreateNewItemFragmentManager : Fragment() {

    private lateinit var binding: FragmentCreateNewItemManagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNewItemManagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            viewPagerCreateItemManager.adapter =
                CreateNewItemAdapter(this@CreateNewItemFragmentManager)
            TabLayoutMediator(tabCreateItemManager, viewPagerCreateItemManager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Period"
                    1 -> tab.text = "Time"
                    2 -> tab.text = "Cycle"
                }
            }.attach()
        }
    }
}