package com.baladev.talentshipnews.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.baladev.talentshipnews.R

/**
 * Created by Bharath Simha Gupta on 2019-11-18.
 */
object Loader {
    private var dialog: Dialog? = null
    fun show(context: Context?) {
        if (context != null) {
            if (dialog != null && dialog!!.isShowing) {
                dialog!!.dismiss()
                dialog = null
            }
            dialog = Dialog(context)
            if (dialog != null) {
                dialog!!.setContentView(R.layout.dots_loader)
                if (dialog!!.window != null) {
                    dialog!!.window!!
                        .setBackgroundDrawable(
                            ColorDrawable(Color.TRANSPARENT)
                        )
                }
                dialog!!.setCancelable(false)
                dialog!!.setCanceledOnTouchOutside(false)
                dialog!!.show()
            }
        }
    }

    fun close() {
        if (dialog != null) {
            dialog!!.cancel()
            dialog = null
        }
    }
}