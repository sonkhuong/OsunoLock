package com.dagoras.osunolock.create_new_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.databinding.FragmentCycleBinding
import com.dagoras.osunolock.model.LockManager
import com.dagoras.osunolock.model.Unlock
import com.dagoras.osunolock.sub_manager_lock.fragment.CreateNewItemFragmentManagerDirections

class CycleFragment : Fragment() {

    //    private val args: CreateNewItemFragmentManagerArgs by navArgs()
    private lateinit var binding: FragmentCycleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCycleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
//        val idPoint = args.type
        val idPoint = 0

        with(binding) {
            if (idPoint == -1 || idPoint == -2) {
                layoutCycle.isEnabled = false
                layoutDisable.isVisible = true
            }

            buttonAdd.setOnClickListener {
                val repeatDay = countingRepeat()
                createNewItem(idPoint, repeatDay)
            }
        }
    }

    private fun navigateToLoadingRequest(unlock: Unlock?, lockManager: LockManager?) {
        val action =
            CreateNewItemFragmentManagerDirections.actionCreateNewItemFragmentManagerToLoadingRequestFragment(
                unlock, lockManager
            )
        findNavController().navigate(action)
    }

    private fun countingRepeat(): String {
        var str = ""
        with(binding) {
            if (customDayOfWeek.monday.isChecked) str += "2"
            if (customDayOfWeek.tuesday.isChecked) str += "3"
            if (customDayOfWeek.wednesday.isChecked) str += "4"
            if (customDayOfWeek.thursday.isChecked) str += "5"
            if (customDayOfWeek.friday.isChecked) str += "6"
            if (customDayOfWeek.saturday.isChecked) str += "7"
            if (customDayOfWeek.sunday.isChecked) str += "8"
        }
        return str
    }

    private fun createNewItem(idPoint: Int, repeatDay: String) {
        when (idPoint) {
            //If choose Passcode, Card... -> Create new Unlock Item
            0, 1, 2, 3 -> {
                val unlock = Unlock(
                    0, 0,
                    0, idPoint, binding.editName.text.toString(), null, null, null, repeatDay
                )
                navigateToLoadingRequest(unlock, null)
            }
        }
    }

    companion object {
        fun newInstance() = CycleFragment()
    }
}