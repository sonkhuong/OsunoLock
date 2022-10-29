package com.dagoras.osunolock.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLayout()
    }

    private fun viewLayout() {
        with(binding) {
            buttonCheck.setOnClickListener {
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
}