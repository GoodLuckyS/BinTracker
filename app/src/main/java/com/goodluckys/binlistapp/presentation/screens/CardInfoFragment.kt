package com.goodluckys.binlistapp.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.goodluckys.binlistapp.databinding.FragmentCardInfoBinding
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.findTopNavController
import com.goodluckys.binlistapp.presentation.BaseFragment

class CardInfoFragment : BaseFragment<FragmentCardInfoBinding>(
    FragmentCardInfoBinding::inflate
) {

    private val args : CardInfoFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateViews(args.cardInfo)

        binding.button.setOnClickListener {
            findTopNavController().popBackStack()
        }

    }

    private fun updateViews(it: CardInfo) {
        binding.apply {
            tvBinNumber.text = it.bin
            tvBankTitle.text = it.bank.name
            tvBankPhone.text = it.bank.phone
            tvBankURL.text = it.bank.url
            tvBankCity.text = it.bank.city
            tvCardCountry.text = it.country
            tvCardBrand.text = it.brand
            tvCardScheme.text = it.scheme
            tvCardType.text = it.type
            tvCardPrepaid.text = it.prepaid
            tvLength.text = it.number.length
            tvLuhn.text = it.number.luhn
        }
    }


}