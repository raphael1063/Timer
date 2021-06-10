package com.robin.timer.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

class BaseViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val fragments: ArrayList<Fragment>
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int =fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
