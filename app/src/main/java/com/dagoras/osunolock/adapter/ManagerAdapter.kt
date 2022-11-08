package com.dagoras.osunolock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dagoras.osunolock.databinding.ItemManagerBinding
import com.dagoras.osunolock.list_manager.ListManagerLockFragment
import com.dagoras.osunolock.list_manager.ListManagerLockFragmentDirections
import com.dagoras.osunolock.models.Manager

class ManagerAdapter(private val fragment: Fragment, private val list: ArrayList<Manager>) :
    RecyclerView.Adapter<ManagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemManagerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    // Get size of recyclerview
    override fun getItemCount(): Int = list.size

    // Bind item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    inner class ViewHolder(private val binding: ItemManagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Manager) {
            with(binding) {
                // Config properties item of recyclerview
                itemTitle.text = item.name
                itemStatus.text = if (item.status == 0) "Out of date" else "Activate"
                itemContent.text = item.content
                itemView.setOnClickListener {
                    navigateToAnotherScreen(fragment, 1)
                }
                itemRemove.setOnClickListener {

                }
            }
        }
    }

    private fun navigateToAnotherScreen(fragment: Fragment, target: Int) {
        when (fragment) {
            ListManagerLockFragment() -> {
                val action =
                    ListManagerLockFragmentDirections.actionListManagerLockFragmentToManagerScanLockFragment()
                fragment.findNavController().navigate(action)
            }
        }
    }
}