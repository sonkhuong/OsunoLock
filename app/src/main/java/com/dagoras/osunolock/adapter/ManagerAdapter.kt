package com.dagoras.osunolock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dagoras.osunolock.databinding.ItemManagerBinding
import com.dagoras.osunolock.list_manager.ListManagerLockFragmentDirections
import com.dagoras.osunolock.models.Manager

class ManagerAdapter(private val fragment: Fragment, private val list: ArrayList<Manager>) :
    RecyclerView.Adapter<ManagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemManagerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    inner class ViewHolder(private val binding: ItemManagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Manager) {
            with(binding) {
                itemTitle.text = item.name
                itemStatus.text = if (item.status == 0) "Out of date" else "Activate"
                itemContent.text = item.content

                itemView.setOnClickListener {
                    navigateToManagerLock(fragment, 0)
                }

                itemRemove.setOnClickListener {

                }
            }
        }
    }

    private fun navigateToManagerLock(fragment: Fragment, position: Int) {
        val action =
            ListManagerLockFragmentDirections.actionListManagerLockFragmentToManagerLockFragment()
        fragment.findNavController().navigate(action)
    }
}