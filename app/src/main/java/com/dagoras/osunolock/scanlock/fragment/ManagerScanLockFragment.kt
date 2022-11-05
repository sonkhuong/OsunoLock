package com.dagoras.osunolock.scanlock.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.FragmentManagerScanLockBinding
import kotlinx.coroutines.*

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
        setupBinding()
        chooseOption()
    }

    private fun chooseOption() {
        with(binding) {
            buttonSmartKey.setOnClickListener {
                navigateToScanLockWithBLT()
            }

            buttonGateKey.setOnClickListener {
                setupChooseAnim(buttonSmartKey, buttonRollingDoor, buttonTimerDoor)
                navigateToScanLockWithBLT()
            }

            buttonRollingDoor.setOnClickListener {
                navigateToScanLockWithBLT()
                setupChooseAnim(buttonGateKey, buttonSmartKey, buttonTimerDoor)
            }

            buttonTimerDoor.setOnClickListener {
                navigateToScanLockWithBLT()
                setupChooseAnim(buttonGateKey, buttonRollingDoor, buttonSmartKey)
            }
        }
    }

    private fun setupBinding() {
        with(binding) {
            buttonSmartKey.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_swipe_start
                )
            )
            buttonRollingDoor.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_swipe_start
                )
            )
            buttonGateKey.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_swipe_end
                )
            )
            buttonTimerDoor.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_swipe_end
                )
            )
        }
    }

    private fun setupChooseAnim(button1: TextView, button2: TextView, button3: TextView) {
        closeButton(button1)
        closeButton(button2)
        closeButton(button3)
    }

    private fun closeButton(button: TextView) {
        with(binding) {
            if (button == buttonSmartKey || button == buttonRollingDoor) {
                button.startAnimation(
                    AnimationUtils.loadAnimation(
                        context,
                        R.anim.anim_swipe_anti_end
                    )
                )
            } else {
                button.startAnimation(
                    AnimationUtils.loadAnimation(
                        context,
                        R.anim.anim_swipe_anti_start
                    )
                )
            }
        }
    }

    private fun navigateToScanLockWithBLT() {
        val action =
            ManagerScanLockFragmentDirections.actionManagerScanLockFragmentToFragmentScanLockWithBLT()
        findNavController().navigate(action)
    }
}