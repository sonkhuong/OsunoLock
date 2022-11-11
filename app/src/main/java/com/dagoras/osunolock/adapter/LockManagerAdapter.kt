package com.dagoras.osunolock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dagoras.osunolock.CurrentTime
import com.dagoras.osunolock.MockupForDemo
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.ItemManagerLockBinding
import com.dagoras.osunolock.list_manager.fragment.ListManagerLockFragmentDirections
import com.dagoras.osunolock.model.Lock
import com.dagoras.osunolock.model.LockManager

class LockManagerAdapter(private val fragment: Fragment, private val list: ArrayList<LockManager>) :
    RecyclerView.Adapter<LockManagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemManagerLockBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    inner class ViewHolder(private val binding: ItemManagerLockBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LockManager) {
            with(binding) {
                itemTitle.text = getLockById(item.id_lock)?.lockName
                itemRule.text = when (item.typeManager) {
                    1 -> "Admin"
                    2 -> "User"
                    else -> "Root Admin"
                }
                itemStatus.text =
                    if (item.startDate!! < CurrentTime.date && item.endDate!! > CurrentTime.date) "Activated" else "Out of date"
                itemContent.text = String.format(
                    root.resources.getString(R.string.date),
                    item.startDate,
                    item.endDate
                )

                itemView.setOnClickListener {
                    navigateToManagerLock(fragment)
                }

                itemRemove.setOnClickListener {

                }
            }
        }
    }

    private fun getLockById(id: Int): Lock? {
        val listLock = MockupForDemo.listLock
        for (i in listLock) {
            if (id == i.id) {
                return i
            }
        }
        return null
    }

    private fun navigateToManagerLock(fragment: Fragment) {
        val action =
            ListManagerLockFragmentDirections.actionListManagerLockFragmentToManagerLockFragment()
        fragment.findNavController().navigate(action)
    }
}