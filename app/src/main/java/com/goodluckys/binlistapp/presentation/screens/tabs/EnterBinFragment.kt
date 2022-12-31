package com.goodluckys.binlistapp.presentation.screens.tabs

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.goodluckys.binlistapp.databinding.FragmentEnterBinBinding
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.findTopNavController
import com.goodluckys.binlistapp.presentation.BaseFragment
import com.goodluckys.binlistapp.presentation.ViewModelFactory
import com.goodluckys.binlistapp.presentation.utils.ERROR_INPUT
import com.goodluckys.binlistapp.presentation.utils.EVENT_READY
import com.goodluckys.binlistapp.presentation.utils.SUCCESS_MESSAGE
import com.goodluckys.binlistapp.presentation.utils.UiState
import com.goodluckys.binlistapp.showToast
import javax.inject.Inject


class EnterBinFragment : BaseFragment <FragmentEnterBinBinding>(
    FragmentEnterBinBinding::inflate
        ) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: EnterBinViewModel

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[EnterBinViewModel::class.java]

        initObservers()

        binding.btGetInfo.setOnClickListener {
        val bin = binding.tvBinInput.text.toString()
            viewModel.getInfo(bin)
            viewModel.setClickEvent(EVENT_READY)
        }

    }

    private fun initObservers() = with(viewModel){

        uiState.observe(viewLifecycleOwner) {
            when(it){
                is UiState.Complete -> {
                    dismissProgress()
                }

                is UiState.Loading -> {
                   showProgress()
                }
                is UiState.Success  -> {
                    navigateWithDirection(it.item)
                    dismissProgress()
                    showToast(SUCCESS_MESSAGE)
                }
                is UiState.Error -> {
                    dismissProgress()
                    showToast(it.error)
                }
            }
        }

        errorInput.observe(viewLifecycleOwner){
            binding.tvBinInput.error = ERROR_INPUT
        }

    }

    private fun navigateWithDirection(cardInfo:CardInfo) {

                val direction = TabsHostFragmentDirections
                    .actionFromTabsToCardInfo(cardInfo)
                findTopNavController().navigate(direction)

        viewModel.setStateUI(UiState.Complete)
    }

    private fun dismissProgress() = with(binding) {
        binInputBox.visibility = View.VISIBLE
        btGetInfo.isClickable = true
        progressBar.visibility = View.GONE
    }

    private fun showProgress() = with(binding){
        binInputBox.visibility = View.GONE
        btGetInfo.isClickable = false
        progressBar.visibility = View.VISIBLE
    }


}