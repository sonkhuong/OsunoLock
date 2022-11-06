package com.dagoras.osunolock.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dagoras.osunolock.create_new_manager.CycleFragment
import com.dagoras.osunolock.create_new_manager.PeriodFragment
import com.dagoras.osunolock.create_new_manager.TimesFragment

class CreateNewItemAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TimesFragment.newInstance()
            1 -> PeriodFragment.newInstance()
            else -> CycleFragment.newInstance()
        }
    }
}
