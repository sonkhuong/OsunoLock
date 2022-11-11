package com.dagoras.osunolock.create_new_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dagoras.osunolock.databinding.FragmentTimeBinding
import com.dagoras.osunolock.model.LockManager
import com.dagoras.osunolock.model.Unlock
import com.dagoras.osunolock.sub_manager_lock.fragment.CreateNewItemFragmentManagerArgs
import com.dagoras.osunolock.sub_manager_lock.fragment.CreateNewItemFragmentManagerDirections

class TimeFragment : Fragment() {

    private val args: CreateNewItemFragmentManagerArgs by navArgs()
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
        setupBinding()
    }

    private fun setupBinding() {
        val idPoint = args.type
        with(binding) {
            if (idPoint == -1 || idPoint == -2) {
                layoutTime.isEnabled = false
            }

            buttonAdd.setOnClickListener {
                createNewItem(idPoint)
            }
        }
    }

    private fun navigateToLoadingRequest(unlock: Unlock?, lockManager: LockManager?) {
        val action =
            CreateNewItemFragmentManagerDirections.actionCreateNewItemFragmentManagerToLoadingRequestFragment(
                unlock,
                lockManager
            )
        findNavController().navigate(action)
    }

    private fun createNewItem(idPoint: Int) {
        when (idPoint) {
            //If choose Passcode, Card... -> Create new Unlock Item
            0, 1, 2, 3, 4 -> {
                val unlock =
                    Unlock(
                        0,
                        idPoint,
                        binding.editName.text.toString(),
                        null,
                        null,
                        binding.editCountingTimes.text.toString().toInt(),
                        null
                    )
                navigateToLoadingRequest(unlock, null)
            }
        }
    }

    companion object {
        fun newInstance() = TimeFragment()
    }

}