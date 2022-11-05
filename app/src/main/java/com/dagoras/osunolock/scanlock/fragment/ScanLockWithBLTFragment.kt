package com.dagoras.osunolock.scanlock.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.adapter.LockAdapter
import com.dagoras.osunolock.databinding.FragmentScanLockWithBltBinding
import com.dagoras.osunolock.models.Lock

class ScanLockWithBLTFragment : Fragment() {

    private lateinit var binding: FragmentScanLockWithBltBinding
//    private lateinit var adapter: LockAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanLockWithBltBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
//        val listLock = arrayListOf(Lock("abc"), Lock("xyz"))
        with(binding) {
//            adapter = LockAdapter()
//            recyclerScanLockWithBLT.adapter = adapter

            buttonNextScreen.setOnClickListener {
                navigateToManagerLock()
            }
        }
    }

    private fun navigateToManagerLock() {
        val action =
            ScanLockWithBLTFragmentDirections.actionFragmentScanLockWithBLTToManagerLockFragment()
        findNavController().navigate(action)
    }
}