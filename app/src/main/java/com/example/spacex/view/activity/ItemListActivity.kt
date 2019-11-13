package com.example.spacex.view.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.R
import com.example.spacex.databinding.ActivityItemListBinding
import com.example.spacex.model.SpaceXModel
import com.example.spacex.util.openActivity
import com.example.spacex.util.replaceFragment
import com.example.spacex.util.showLoadingDialog
import com.example.spacex.util.viewModel
import com.example.spacex.view.fragment.ItemDetailFragment
import com.example.spacex.view.fragment.ItemDetailFragment.Companion.ARG_ITEM_ID
import com.example.spacex.viewmodel.spacexlist.SpaceXViewModel
import com.example.spacex.viewmodel.spacexlist.adapters.SpaceAdapter

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity(), SpaceAdapter.SpaceAdapterI {

    private lateinit var itemListBinding: ActivityItemListBinding
    private val spaceXModel: SpaceXViewModel by viewModel {
        SpaceXViewModel(this)
    }
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane: Boolean = false
    private val dialog: AlertDialog by showLoadingDialog {
        cancelable = false
        setMessage("Loading data...")
        setRetryVisibility()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemListBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_list)
        spaceXModel.adapter.listener = this
        spaceXModel.loadData()
        itemListBinding.viewModel = spaceXModel
        itemListBinding.lifecycleOwner = this
        val toolbar = itemListBinding.toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title
        spaceXModel.dataLoading.observe(this, Observer { aBoolean ->
            if (aBoolean!!) {
                dialog.show()
            } else
                dialog.dismiss()
        })

        if (itemListBinding.itemListContainer.itemDetailContainer != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true
        }

        itemListBinding.itemListContainer.itemList.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = recyclerView.layoutManager!!.childCount
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                val pastVisibleItems =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                    spaceXModel.loadNextData()
                }

            }
        })

    }

    override fun itemSelected(spaceXModel: SpaceXModel) {
        when {
            mTwoPane ->
                replaceFragment(R.id.item_detail_container, ItemDetailFragment()) {
                    putParcelable(ARG_ITEM_ID, spaceXModel)
                }
            !mTwoPane ->
                openActivity(ItemDetailActivity::class.java) {
                    putParcelable(ARG_ITEM_ID, spaceXModel)
                }
        }
    }
}