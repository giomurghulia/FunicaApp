package com.example.funicaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.funicaapp.databinding.LayoutMenuItemBinding


class MenuAdapter : ListAdapter<MenuItem, MenuAdapter.MyViewHolder>(MyDiffUtil<MenuItem>()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutMenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    inner class MyViewHolder(
        private val binding: LayoutMenuItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MenuItem) {
            binding.itemIconImage.setImageResource(item.icon)
            binding.itemNameText.text = item.title
            if (item.description != null) {
                binding.itemDescriptionText.text = item.description
                binding.itemDescriptionText.visibility = View.VISIBLE
            } else {
                binding.itemDescriptionText.visibility = View.GONE
            }

            if (item.enterIcon != null) {
                binding.itemEnterImage.setImageResource(item.enterIcon)
                binding.itemEnterImage.visibility = View.VISIBLE
            } else {
                binding.itemEnterImage.visibility = View.GONE
            }

            if(item.hasSwitch){
                binding.itemEnterImage.visibility = View.GONE
                binding.itemSwitch.visibility = View.VISIBLE
            }else{
                binding.itemSwitch.visibility = View.GONE
                binding.itemEnterImage.visibility = View.VISIBLE
            }

        }
    }

}