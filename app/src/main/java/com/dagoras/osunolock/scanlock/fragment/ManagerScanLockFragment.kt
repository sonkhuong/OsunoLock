package com.dagoras.osunolock.scanlock.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.FragmentManagerScanLockBinding

class ManagerScanLockFragment : Fragment() {

    private lateinit var binding: FragmentManagerScanLockBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManagerScanLockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLayout()
        findLock()
    }

    private fun findLock() {
        with(binding) {
            buttonDoorLock.setOnClickListener {
                val action =
                    ManagerScanLockFragmentDirections.actionManagerScanLockFragmentToFragmentScanLockWithBLT2()
                findNavController().navigate(action)
            }

            buttonCarLock.setOnClickListener {
                val action =
                    ManagerScanLockFragmentDirections.actionManagerScanLockFragmentToViewControlLockFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun viewLayout() {
        with(binding) {
            buttonDoorLock.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_swipe_end
                )
            )
            buttonUnKnowLock.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_fade_in
                )
            )
            buttonSmartLock.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_slide_up
                )
            )
            buttonHomeLock.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_slide_down
                )
            )
            buttonCarLock.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_swipe_end
                )
            )
            buttonViceLock.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_swipe_start
                )
            )
        }
    }
}