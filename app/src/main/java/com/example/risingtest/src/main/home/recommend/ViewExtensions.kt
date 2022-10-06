package com.example.risingtest.src.main.home.recommend

import android.view.View
import android.view.ViewGroup

class ViewExtensions {
    fun View.setMargins(
        left: Int? = null,
        top: Int? = null,
        right: Int? = null,
        bottom: Int? = null
    ) {
        val lp = layoutParams as? ViewGroup.MarginLayoutParams
            ?: return

        lp.setMargins(
            left ?: lp.leftMargin,
            top ?: lp.topMargin,
            right ?: lp.rightMargin,
            bottom ?: lp.bottomMargin
        )

        layoutParams = lp
    }
}