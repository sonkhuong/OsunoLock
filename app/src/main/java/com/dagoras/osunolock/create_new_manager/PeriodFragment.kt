package com.dagoras.osunolock.create_new_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.databinding.FragmentPeriodBinding
import com.dagoras.osunolock.sub_manager_lock.fragment.CreateNewItemFragmentManagerDirections

class PeriodFragment : Fragment() {

    private lateinit var binding: FragmentPeriodBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPeriodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            buttonAdd.setOnClickListener {
                navigateToLoadingRequest()
            }
        }
    }

    private fun navigateToLoadingRequest() {
        val action =
            CreateNewItemFragmentManagerDirections.actionCreateNewItemFragmentManagerToLoadingRequestFragment()
        findNavController().navigate(action)
    }

    companion object {
        fun newInstance() = PeriodFragment()
    }

}