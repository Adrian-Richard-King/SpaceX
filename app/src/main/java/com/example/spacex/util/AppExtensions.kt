package com.example.spacex.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.spacex.R
import com.example.spacex.network.LoadingDialog
import java.text.SimpleDateFormat
import java.util.*

inline fun <reified VM : ViewModel> Fragment.viewModel(crossinline provider: () -> VM): Lazy<VM> {
    return lazy {
        val factory = object : ViewModelProvider.Factory {
            override fun <T1 : ViewModel> create(aClass: Class<T1>): T1 {
                val viewModel = provider.invoke()
                return viewModel as T1
            }
        }
        ViewModelProviders.of(this, factory).get(VM::class.java)
    }
}

inline fun <reified VM : ViewModel> FragmentActivity.viewModel(crossinline provider: () -> VM): Lazy<VM> {
    return lazy {
        val factory = object : ViewModelProvider.Factory {
            override fun <T1 : ViewModel> create(aClass: Class<T1>): T1 {
                val viewModel = provider.invoke()
                return viewModel as T1
            }
        }
        ViewModelProviders.of(this, factory).get(VM::class.java)
    }
}

fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commitAllowingStateLoss()
}

fun FragmentActivity.replaceFragment(
    frameId: Int,
    fragment: Fragment,
    extras: Bundle.() -> Unit = {}
) {
    fragment.arguments = Bundle().apply(extras)
    supportFragmentManager.inTransaction {
        setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        replace(frameId, fragment)
    }
}

fun FragmentActivity.addFragment(frameId: Int, fragment: Fragment, extras: Bundle.() -> Unit = {}) {
    fragment.arguments = Bundle().apply(extras)
    supportFragmentManager.inTransaction {
        setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        add(frameId, fragment)
    }
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

@BindingAdapter("app:imageUrl")
fun ImageView.loadImg(imageUrl: String?) {
    Glide.with(context)
        .load(imageUrl)
        .centerCrop()
        .placeholder(R.mipmap.flight)
        .into(this)
}

fun String.toDate(
    dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): Date? {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(this)
}

fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    formatter.timeZone = timeZone
    return formatter.format(this)
}

inline fun Activity.showLoadingDialog(crossinline func: LoadingDialog.() -> Unit?): Lazy<AlertDialog> =
    lazy {
        LoadingDialog(this).apply {
            func()
        }.create()
    }