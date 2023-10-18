package com.omarismayilov.advancednavigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.omarismayilov.advancednavigation.ui.EFragment
import com.omarismayilov.advancednavigation.ui.FFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EFragment()
            1 -> FFragment()
            else -> {FFragment()}
        }
    }

}