package com.patikadev.deneme1.utils

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.IdRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


inline fun Fragment.navigateToNextFragment(@IdRes id: Int, block: Bundle.() -> Unit = {}) {
    findNavController().navigate(id, Bundle().apply(block))
}

fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE

}

fun Fragment.onBackPopup() =
    requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            AlertDialog.Builder(requireContext())
                .setTitle("Dikkat")
                .setMessage("Uygulamadan çıkmak istediğinize emin misiniz?")
                .setCancelable(false)
                .setNegativeButton("Evet") {_ ,_ ->requireActivity().finish() }
                .setPositiveButton("Hayır") { dialog, _ ->dialog.dismiss() }.show()
        }
    })