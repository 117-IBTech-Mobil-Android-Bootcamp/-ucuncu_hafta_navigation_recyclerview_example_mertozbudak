package com.patikadev.deneme1.recyclerview.model

import java.io.Serializable

data class Avatar(
    val avatar : String="",
    var value: Boolean = false,
    val drawable : Int=0,
    val index : Int,
) : Serializable

