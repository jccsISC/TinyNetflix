package com.jccsisc.tinynetflix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jccsisc.tinynetflix.databinding.SectionListItemBinding
import com.jccsisc.tinynetflix.model.SectionModel

class SectionAdapter : ListAdapter<SectionModel, SectionAdapter.SectionViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<SectionModel>() {
        override fun areItemsTheSame(oldItem: SectionModel, newItem: SectionModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SectionModel, newItem: SectionModel): Boolean {
            return oldItem.name == oldItem.name
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = SectionListItemBinding.inflate(LayoutInflater.from(parent.context))
        return SectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val sectionModel = getItem(position)
        holder.bind(sectionModel)
    }

    //Mantiene los elementos del recycler
    inner class SectionViewHolder(private val binding: SectionListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sectionModel: SectionModel) = with(binding) {
            txtSectionNameText.text = sectionModel.name
        }
    }
}