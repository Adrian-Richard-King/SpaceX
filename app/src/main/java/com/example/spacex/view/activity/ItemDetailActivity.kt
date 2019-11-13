package com.example.spacex.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.spacex.R
import com.example.spacex.databinding.ActivityItemDetailBinding
import com.example.spacex.model.SpaceXModel
import com.example.spacex.util.addFragment
import com.example.spacex.util.viewModel
import com.example.spacex.view.fragment.ItemDetailFragment
import com.example.spacex.view.fragment.ItemDetailFragment.Companion.ARG_ITEM_ID
import com.example.spacex.viewmodel.spacexdetails.SpaceXDetailsViewModel

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ItemListActivity].
 */
class ItemDetailActivity : AppCompatActivity() {

    private lateinit var activityItemDetailBinding: ActivityItemDetailBinding
    private val spaceXViewModel: SpaceXDetailsViewModel by viewModel {
        SpaceXDetailsViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityItemDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_item_detail)
        activityItemDetailBinding.apply {
            viewModel = spaceXViewModel
            lifecycleOwner = this@ItemDetailActivity
            setSupportActionBar(detailToolbar)
        }

        val spaceXModel = intent.getParcelableExtra<SpaceXModel>(ARG_ITEM_ID)
        spaceXViewModel.selectedData = spaceXModel

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            addFragment(R.id.item_detail_container, ItemDetailFragment()) {
                putParcelable(ARG_ITEM_ID, spaceXModel)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {

            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
