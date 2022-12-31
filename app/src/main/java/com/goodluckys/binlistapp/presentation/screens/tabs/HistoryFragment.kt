package com.goodluckys.binlistapp.presentation.screens.tabs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.goodluckys.binlistapp.databinding.FragmentHistoryBinding
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.findTopNavController
import com.goodluckys.binlistapp.presentation.BaseFragment
import com.goodluckys.binlistapp.presentation.HistoryListAdapter
import com.goodluckys.binlistapp.presentation.ViewModelFactory
import com.goodluckys.binlistapp.presentation.utils.UiState
import javax.inject.Inject

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(
    FragmentHistoryBinding::inflate
) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: HistoryViewModel

    lateinit var historyListAdapter: HistoryListAdapter

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        viewModel = ViewModelProvider(this, viewModelFactory)[HistoryViewModel::class.java]
        viewModel.historyList.observe(viewLifecycleOwner) {
            historyListAdapter.submitList(it)
        }

    }


    private fun setRecyclerView() {
        val layoutManager = LinearLayoutManager(context) // context
        historyListAdapter = HistoryListAdapter()
        with(binding) {
            rcView.adapter = historyListAdapter
            rcView.layoutManager = layoutManager
        }

        historyListAdapter.onClickListener = {
            navigateWithDirection(it)
        }
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = historyListAdapter.currentList[viewHolder.adapterPosition]
                Log.e("tag",item.toString())
                viewModel.deleteCardInfo(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rcView)

    }

    private fun navigateWithDirection(cardInfo: CardInfo) {
        val direction = TabsHostFragmentDirections
            .actionFromTabsToCardInfo(cardInfo)
        findTopNavController().navigate(direction)


    }

}