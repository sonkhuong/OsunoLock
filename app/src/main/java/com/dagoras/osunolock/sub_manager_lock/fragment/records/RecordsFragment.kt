package com.dagoras.osunolock.sub_manager_lock.fragment.records

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.databinding.FragmentManagerListBinding

class RecordsFragment : Fragment() {

    private lateinit var binding: FragmentManagerListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManagerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            buttonAddItem.setOnClickListener {
                navigateToCreateItemManager()
            }
        }
    }

    private fun navigateToCreateItemManager() {
        val action = RecordsFragmentDirections.actionRecordsFragmentToCreateNewItemFragmentManager(4)
        findNavController().navigate(action)
    }
}