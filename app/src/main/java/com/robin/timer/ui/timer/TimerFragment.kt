package com.robin.timer.ui.timer

import android.os.Bundle
import com.robin.timer.R
import com.robin.timer.BR
import com.robin.timer.base.BaseFragment
import com.robin.timer.databinding.FragmentTimerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TimerFragment : BaseFragment<FragmentTimerBinding, TimerViewModel>() {

    override val layoutRes = R.layout.fragment_timer
    override val viewModel: TimerViewModel by viewModel()
    override val viewModelVariable = BR.vm

    override fun start() {

    }

    override fun observe() {
    }

    companion object {
        fun instance() = TimerFragment()
    }
}