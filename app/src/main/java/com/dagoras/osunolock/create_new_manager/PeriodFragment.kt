package com.dagoras.osunolock.create_new_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.databinding.FragmentPeriodBinding
import com.dagoras.osunolock.model.LockManager
import com.dagoras.osunolock.model.Unlock
import com.dagoras.osunolock.sub_manager_lock.fragment.CreateNewItemFragmentManagerDirections

class PeriodFragment : Fragment() {

    //    private val args: CreateNewItemFragmentManagerArgs by navArgs()
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
        val idPoint = 0

        with(binding) {
            when (idPoint) {
                0, 1, 2, 3 -> linearReceiver.isVisible = false
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
            0, 1, 2, 3 -> {
                val unlock =
                    Unlock(
                        0,
                        0,
                        0,
                        idPoint,
                        binding.editName.text.toString(),
                        binding.dateStartDate.text.toString(),
                        binding.dateEndDate.text.toString(),
                        null,
                        null
                    )
                navigateToLoadingRequest(unlock, null)
            }
            //If choose EKey or Admin -> Create new LockManager Item
            -1, -2 -> {
                val lockManager = LockManager(
                    0,
                    1,
                    0,
                    0,
                    idPoint + 3,
                    binding.dateStartDate.text.toString(),
                    binding.dateEndDate.text.toString(),
                    null,
                    null
                )
                navigateToLoadingRequest(null, lockManager)
            }
        }
    }

    companion object {
        fun newInstance() = PeriodFragment()
    }

}