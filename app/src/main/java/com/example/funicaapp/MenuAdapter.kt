package com.example.funicaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.funicaapp.databinding.LayoutMenuItemBinding
import com.example.funicaapp.databinding.LayoutProfileBinding


class MenuAdapter :
    ListAdapter<SettingListItem, RecyclerView.ViewHolder>(MyDiffUtil<SettingListItem>()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            SettingListItem.ViewType.PROFILE.ordinal -> {
                return ProfileViewHolder(
                    LayoutProfileBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                return MenuViewHolder(
                    LayoutMenuItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        when (holder) {
            is MenuViewHolder -> holder.bind(item as SettingListItem.MenuItem)
            is ProfileViewHolder -> holder.bind(item as SettingListItem.Profile)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).Id.ordinal
    }

    inner class ProfileViewHolder(
        private val binding: LayoutProfileBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SettingListItem.Profile) {
            binding.avatarImage.setImageResource((item.profileImg))
            binding.userNameText.text = item.fullName
            binding.userNumberText.text = item.mobileNumber
        }
    }

    inner class MenuViewHolder(
        private val binding: LayoutMenuItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SettingListItem.MenuItem) {
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

            if (item.hasSwitch) {
                binding.itemEnterImage.visibility = View.GONE
                binding.itemSwitch.visibility = View.VISIBLE
            } else {
                binding.itemSwitch.visibility = View.GONE
                binding.itemEnterImage.visibility = View.VISIBLE
            }

        }
    }

}