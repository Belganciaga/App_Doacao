package com.example.appdoacao


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdoacao.databinding.ItemRowBinding

// O adapter recebe a lista de itens e uma função de clique
class ItemAdapter(
    private var items: List<Item>,
    private val onItemClicked: (Item) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // ViewHolder: Mapeia as views do item_row.xml
    inner class ItemViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvItemTitle.text = item.title
            binding.tvItemCategory.text = item.category

            // Configura o clique no item
            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    // Função para atualizar a lista do adapter
    fun updateData(newItems: List<Item>) {
        items = newItems
        notifyDataSetChanged()
    }
}