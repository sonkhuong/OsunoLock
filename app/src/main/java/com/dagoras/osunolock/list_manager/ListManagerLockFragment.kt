package com.dagoras.osunolock.list_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dagoras.osunolock.MockupForDemo
import com.dagoras.osunolock.adapter.ManagerAdapter
import com.dagoras.osunolock.databinding.FragmentListManagerLockBinding

class ListManagerLockFragment : Fragment() {

    private lateinit var binding: FragmentListManagerLockBinding
    private lateinit var adapter: ManagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListManagerLockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        val listMyLock = MockupForDemo.listMyLock
        adapter = ManagerAdapter(this, listMyLock)
        with(binding) {
            recyclerMyLock.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerMyLock.adapter = adapter
        }
    }
}