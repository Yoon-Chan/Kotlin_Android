package com.example.project6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.project6.databinding.ItemWordBinding

class WordAdapter(
    val data: MutableList<Word>,
    private val itemClickListener: ItemClickListener? = null
) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    inner class WordViewHolder(private val binding: ItemWordBinding) : ViewHolder(binding.root) {
        fun bind(word: Word) {
            binding.apply {
                textTextView.text = word.text
                meanTextView.text = word.mean
                typeChip.text = word.type
            }

        }

    }


    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = data[position]
        holder.bind(word)
//        holder.binding.apply {
//            val word = data[position]
//            textTextView.text = word.text
//            meanTextView.text = word.mean
//            typeChip.text = word.type
//        }
        holder.itemView.setOnClickListener { itemClickListener?.onClick(word) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemWordBinding.inflate(inflater, parent, false)

        return WordViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    interface ItemClickListener {
        fun onClick(word: Word)
    }
}