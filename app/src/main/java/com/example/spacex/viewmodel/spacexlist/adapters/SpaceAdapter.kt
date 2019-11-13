package com.example.spacex.viewmodel.spacexlist.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.R
import com.example.spacex.model.SpaceXModel
import com.example.spacex.util.*
import com.example.spacex.util.Utils.dateFormatYYYYMMDD
import kotlinx.android.synthetic.main.item_spacex_list.view.*
import java.util.*

class SpaceAdapter(
    private val mContext: Context,
    private val spaceX_List: ArrayList<SpaceXModel>
) : CustomRecyclerViewAdapter<SpaceXModel, SpaceAdapter.MyViewHolder>() {

    private var selectedPosition = -1
    var listener: SpaceAdapterI? = null

    override fun updateData(data: List<SpaceXModel>) {
        if (data.isEmpty()) {
            this.spaceX_List.clear()
        } else {
            this.spaceX_List.addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(parent.inflate(R.layout.item_spacex_list))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.loadData(position)

    override fun getItemCount(): Int = spaceX_List.size


    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun loadData(position: Int) {
            val spaceXModel = spaceX_List[position]
            view.apply {
                setBackgroundColor(getBackgroundColor(position))

                con_layoutMain.tag = position
                con_layoutMain.setOnClickListener {
                    listener?.itemSelected(spaceXModel)
                    selectedPosition = position
                    notifyDataSetChanged()
                }

                tv_MissionName.text = spaceXModel.mission_name
                tv_RocketName.text = spaceXModel.rocket?.rocket_name
                tv_LaunchSiteName.text = spaceXModel.launch_site?.site_name
                tv_DateOfLaunch.text =
                    spaceXModel.launch_date_utc?.toDate()?.formatTo(dateFormatYYYYMMDD)

                img_launchPathImage.loadImg(spaceXModel.links?.mission_patch_small)

            }

        }

        private fun getBackgroundColor(position: Int): Int =
            if (selectedPosition == position)
                ContextCompat.getColor(mContext, R.color.colorAccent)
            else ContextCompat.getColor(mContext, android.R.color.white)

    }

    interface SpaceAdapterI {
        fun itemSelected(spaceXModel: SpaceXModel)
    }
}