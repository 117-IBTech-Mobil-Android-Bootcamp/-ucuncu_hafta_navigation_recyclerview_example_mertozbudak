package com.patikadev.deneme1.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseRecyclerViewItemClickListener
import com.patikadev.deneme1.recyclerview.model.Avatar

class MatchmakingResultAdapter(private val avatarList: List<Avatar>) : RecyclerView.Adapter<AvatarViewHolder>() {

    private lateinit var matchmakingResultAdapter: MatchmakingResultAdapter
    private var itemClickListener : BaseRecyclerViewItemClickListener<Avatar>  ?= null
    val lastSelectedItem = -1

    constructor(avatarList: List<Avatar>, itemClickListener: BaseRecyclerViewItemClickListener<Avatar>) : this(avatarList){
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarViewHolder {
        return AvatarViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_avatar, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AvatarViewHolder, position: Int) {
        val avatar = this.avatarList[position]
        holder.setData(avatar)
        holder.setOnItemClickListener(avatar, this.itemClickListener!!)
    }

    override fun getItemCount(): Int = this.avatarList.size

    fun notifyChanges(clickedItem : Avatar){
        val clickedIndex = this.avatarList.indexOf(clickedItem)
        notifyItemChanged(clickedIndex)

    }
}

class AvatarViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    val avatarview  = itemview.findViewById<AppCompatImageView>(R.id.avatarview)
    val avatar_is_selected    = itemview.findViewById<AppCompatImageView>(R.id.avatar_is_selected)

    fun setData(avatar: Avatar) {

        avatarview.setImageResource(avatar.drawable)
        avatar_is_selected.setImageResource(if(avatar.value) R.drawable.success else R.drawable.emptycircle)
    }

    fun setOnItemClickListener(
        avatar: Avatar,
        itemClickListener: BaseRecyclerViewItemClickListener<Avatar>?
    ) {
        avatar_is_selected.setOnClickListener {
            avatar.value = !avatar.value
            avatar_is_selected.setImageResource(if (avatar.value) R.drawable.success else R.drawable.emptycircle)
          itemClickListener!!.onItemClicked(avatar, it.id)
      }

        avatarview.setOnClickListener {
            itemClickListener!!.onItemClicked(avatar, it.id)
        }
    }




}