package com.dagoras.osunolock.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dagoras.osunolock.databinding.ItemMyLockBinding
import com.dagoras.osunolock.models.MyLock

class MyLockAdapter(private val list: ArrayList<MyLock>) :
    RecyclerView.Adapter<MyLockAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMyLockBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    // Get size of recyclerview
    override fun getItemCount(): Int = list.size

    // Bind item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    inner class ViewHolder(private val binding: ItemMyLockBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyLock) {
            with(binding) {
                // Config properties item of recyclerview
                itemTitle.text = item.name
                itemStatus.text = if (item.status == 0) "Out of date" else "Activate"
                itemContent.text = item.content
                itemView.setOnClickListener {
                    Log.d("Test Log:", "Abc")
                }
                itemRemove.setOnClickListener {

                }
            }
        }
    }
}

