package com.goodluckys.binlistapp.presentation.screens.tabs

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.goodluckys.binlistapp.R
import com.goodluckys.binlistapp.databinding.TabsHostFragmentBinding
import com.goodluckys.binlistapp.presentation.BaseFragment


class TabsHostFragment : BaseFragment<TabsHostFragmentBinding>(
    TabsHostFragmentBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = childFragmentManager.findFragmentById(R.id.tabsContainer) as NavHostFragment
        val navController = navHost.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navController)


    }



}