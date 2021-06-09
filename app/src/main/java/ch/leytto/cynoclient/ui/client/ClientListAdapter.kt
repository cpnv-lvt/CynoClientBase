package ch.leytto.cynoclient.ui.client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ch.leytto.cynoclient.Constants
import ch.leytto.cynoclient.R
import ch.leytto.cynoclient.db.entities.relations.ClientWithLocality

class ClientListAdapter : ListAdapter<ClientWithLocality, ClientListAdapter.ClientViewHolder>(
    ClientsComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        return ClientViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameItemView: TextView = itemView.findViewById(R.id.name)

        fun bind(client: ClientWithLocality?) {
            nameItemView.text = client?.client?.firstname + " " + client?.client?.lastname + " " + client?.locality?.noun

            itemView.setOnClickListener {
                val bundle = bundleOf(Constants.ID_KEY to client?.client?.id)
                itemView.findNavController().navigate(R.id.action_client_to_clientDetail, bundle)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ClientViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.client_adapter, parent, false)
                return ClientViewHolder(view)
            }
        }
    }

    class ClientsComparator : DiffUtil.ItemCallback<ClientWithLocality>() {
        override fun areItemsTheSame(oldItem: ClientWithLocality, newItem: ClientWithLocality): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ClientWithLocality, newItem: ClientWithLocality): Boolean {
            return oldItem.client.id == newItem.client.id
        }
    }
}