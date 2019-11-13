package com.example.spacex.network

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.spacex.R
import com.google.android.material.button.MaterialButton

class LoadingDialog(val context: Context) : BaseDialogHelper() {

    override val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.loading_layout, null)
    }

    override val builder: AlertDialog.Builder
        get() = AlertDialog.Builder(context).setView(dialogView)

    private val progressMessage: TextView by lazy {
        dialogView.findViewById<TextView>(R.id.progress_message)
    }

    //  retry button
    private val retry: MaterialButton by lazy {
        dialogView.findViewById<MaterialButton>(R.id.btn_retry)
    }

    fun setMessage(msg: String) = with(progressMessage) { text = msg }

    fun setRetryVisibility(isVisible: Boolean = false) {
        retry.apply {
            visibility = if (isVisible) View.VISIBLE else View.GONE
        }
    }

    fun retryClickListener(func: (() -> Unit)? = null) =
        with(retry) {
            setClickListenerToDialog(func)
        }

    //  view click listener as extension function
    private fun View.setClickListenerToDialog(func: (() -> Unit)?) =
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
}