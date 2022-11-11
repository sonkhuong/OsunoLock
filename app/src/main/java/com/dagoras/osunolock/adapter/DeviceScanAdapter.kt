package com.dagoras.osunolock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dagoras.osunolock.databinding.ItemDeviceScanBinding
import com.dagoras.osunolock.model.DeviceInfo

class DeviceScanAdapter(private val list: MutableList<DeviceInfo>) :
    RecyclerView.Adapter<DeviceScanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDeviceScanBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    inner class ViewHolder(private val binding: ItemDeviceScanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DeviceInfo) {
            with(binding) {
                itemLockName.text = item.name
            }
        }
    }
}