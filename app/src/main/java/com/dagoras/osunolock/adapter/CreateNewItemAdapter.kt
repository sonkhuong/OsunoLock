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
            0 -> PeriodFragment.newInstance()
            1 -> TimeFragment.newInstance()
            else -> CycleFragment.newInstance()
        }
    }
}
