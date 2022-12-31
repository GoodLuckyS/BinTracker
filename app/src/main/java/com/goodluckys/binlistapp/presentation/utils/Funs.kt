package com.goodluckys.binlistapp

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController


fun Fragment.showToast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.findChildNavController(id: Int): NavController {
    val navHost = childFragmentManager.findFragmentById(id) as NavHostFragment
    return navHost.navController
}

fun Fragment.findTopNavController(): NavController {
    val topLevelHost =
        requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment?
    return topLevelHost?.navController ?: findNavController()
}

fun Boolean?.mapToString(): String {
    return when (this) {
        true -> "Yes"
        false -> "No"
        null -> "???"
    }
}

fun Any?.mapToString(): String {
    return when (this) {
        null -> "???"
        else -> this.toString()
    }
}



