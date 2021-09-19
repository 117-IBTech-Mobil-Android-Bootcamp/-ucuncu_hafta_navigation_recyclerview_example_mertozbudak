package com.patika.homework3.ui.recyclerview.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.navigation.fragment.findNavController
import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseFragment
import com.patikadev.deneme1.utils.navigateToNextFragment


class FragmentSplash : BaseFragment() {

    override fun getLayoutID(): Int = R.layout.fragment_splash

    private val DELAY  :  Long = 3 * 1000
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //After 3 seconds, splash fragment is redirected to home fragment
        val timer = object: CountDownTimer(DELAY, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                navigateToNextFragment(R.id.action_fragment5_to_fragment1)
                findNavController().popBackStack(R.id.fragment5,true)
            }
        }.start()
        println(timer)
    }

    //hide bottom navigation bar
    override fun isNavigationbarVisible() = false
}
