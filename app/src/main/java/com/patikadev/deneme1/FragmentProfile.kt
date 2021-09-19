package com.patikadev.deneme1
import android.os.Bundle
import android.view.View
import com.patikadev.deneme1.base.BaseFragment
import com.patikadev.deneme1.utils.navigateToNextFragment
import com.patikadev.deneme1.utils.onBackPopup
import kotlinx.android.synthetic.main.fragment_profile.*

class FragmentProfile : BaseFragment() {

    override fun getLayoutID(): Int =  R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPopup()
        editBttn.setOnClickListener {
            navigateToNextFragment(R.id.action_fragment1_to_fragment4)
        }
    }





}