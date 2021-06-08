package com.robin.timer.ui.main

import com.robin.timer.R
import com.robin.timer.BR
import com.robin.timer.base.BaseActivity
import com.robin.timer.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutRes = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()
    override val viewModelVariable = BR.vm

    override fun start() {

    }

    override fun observe() {

    }
}