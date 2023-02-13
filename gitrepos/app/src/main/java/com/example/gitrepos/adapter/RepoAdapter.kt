package com.example.gitrepos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrepos.databinding.ItemRepoBinding
import com.example.gitrepos.model.Repo

class RepoAdapter(private val onClick : (Repo) -> Unit) : ListAdapter<Repo, RepoAdapter.ViewHolder >(diffUtil) {
    inner class ViewHolder(private val viewbinding: ItemRepoBinding) : RecyclerView.ViewHolder(viewbinding.root){
        fun bind(item: Repo) {
            viewbinding.repoNameTextView.text = item.name
            viewbinding.descriptionTextView.text = item.description
            viewbinding.starCountTextView.text = item.stargazers_count.toString()
            viewbinding.forkCountTextView.text =item.forks_count.toString()

            viewbinding.root.setOnClickListener {
                onClick(item)
            }
        }

    }
    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<Repo>(){
            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}