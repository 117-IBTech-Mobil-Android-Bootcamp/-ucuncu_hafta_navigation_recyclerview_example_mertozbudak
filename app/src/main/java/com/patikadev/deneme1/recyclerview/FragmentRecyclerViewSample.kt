package com.patikadev.deneme1.recyclerview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.patikadev.deneme1.HomeActivity
import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseFragment
import com.patikadev.deneme1.base.BaseRecyclerViewItemClickListener
import com.patikadev.deneme1.recyclerview.adapter.MatchmakingResultAdapter
import com.patikadev.deneme1.recyclerview.adapter.AvatarViewHolder
import com.patikadev.deneme1.recyclerview.model.Avatar
import kotlinx.android.synthetic.main.fragment_recyclerview_sample.*

class FragmentRecyclerViewSample : BaseFragment() {


    private lateinit var matchmakingResultAdapter: MatchmakingResultAdapter

    override fun getLayoutID(): Int  = R.layout.fragment_recyclerview_sample

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(view)
    }
    //Filling all avatars to list
    private fun prepareView(view: View) {
        (requireActivity() as HomeActivity).hideNavigation()

        val word1 = Avatar("avatar01", false, R.drawable.avatar01, 0)
        val word2 = Avatar("avatar02", false, R.drawable.avatar02,1)
        val word3 = Avatar("avatar03", false, R.drawable.avatar03,2)
        val word4 = Avatar("avatar04", false, R.drawable.avatar04,3)
        val word5 = Avatar("avatar05", false, R.drawable.avatar05,4)
        val word6 = Avatar("avatar06", false, R.drawable.avatar06,5)
        val word7 = Avatar("avatar07", false, R.drawable.avatar07,6)
        val word8 = Avatar("avatar08", false, R.drawable.avatar08,7)
        val word9 = Avatar("avatar09", false, R.drawable.avatar09,8)

        val list = mutableListOf(word1, word2 ,word3, word4 , word5, word6, word7, word8, word9)

        matchmakingResultAdapter = MatchmakingResultAdapter(list, object  : BaseRecyclerViewItemClickListener<Avatar> {
            override fun onItemClicked(clickedObject: Avatar, id : Int) {

                when(id){
                    R.id.avatarview -> {
                        Toast.makeText(requireContext(), "tıklanan status ${clickedObject.value}", Toast.LENGTH_SHORT).show()

                    }
                    R.id.avatar_is_selected ->{

                    }
                }
            }

        })
        recyclerview.adapter  = matchmakingResultAdapter
    }


    override fun isNavigationbarVisible() = false

}