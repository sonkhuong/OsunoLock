package com.dagoras.osunolock.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dagoras.osunolock.R
import com.dagoras.osunolock.model.DeviceInfo

class DeviceScanAdapter(private val dataSet: List<DeviceInfo>) :
    RecyclerView.Adapter<DeviceScanAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.itemLockName)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_device_scan, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].name
        viewHolder.textView.setOnClickListener {
        }
    }

    override fun getItemCount() = dataSet.size
}