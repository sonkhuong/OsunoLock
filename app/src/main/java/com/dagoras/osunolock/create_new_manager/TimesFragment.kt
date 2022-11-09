package com.dagoras.osunolock.create_new_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagoras.osunolock.databinding.FragmentTimeBinding

class TimesFragment : Fragment() {

    private lateinit var binding: FragmentTimeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupBinding()
    }

    companion object {
        fun newInstance() = TimesFragment()
    }

}