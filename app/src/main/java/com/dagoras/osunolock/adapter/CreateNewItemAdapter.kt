package com.dagoras.osunolock.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dagoras.osunolock.create_new_manager.CycleFragment
import com.dagoras.osunolock.create_new_manager.PeriodFragment
import com.dagoras.osunolock.create_new_manager.TimeFragment

class CreateNewItemAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TimeFragment.newInstance()
            1 -> PeriodFragment.newInstance()
            else -> CycleFragment.newInstance()
        }
    }
}
