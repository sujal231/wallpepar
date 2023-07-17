package com.example.wallpepar.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.wallpepar.Model.PhotosItem
import com.example.wallpepar.databinding.WallpeparitemBinding

class WallpaperAdapter : RecyclerView.Adapter<WallpaperAdapter.wallpaperHolder>() {

    lateinit var wallpaper: ArrayList<PhotosItem>
    lateinit var context: Context


    class wallpaperHolder(itemView: WallpeparitemBinding) : ViewHolder(itemView.root) {
        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wallpaperHolder {
        context = parent.context
        var binding = WallpeparitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return wallpaperHolder(binding)
    }

    override fun getItemCount(): Int {
        return wallpaper.size
    }

    override fun onBindViewHolder(holder: wallpaperHolder, position: Int) {
        holder.binding.apply {
            wallpaper.get(position)?.src?.apply {
                Glide.with(context).load(portrait).into(imgwallpepar)
            }
        }
    }

    fun setwallpepar(wallpaper: List<PhotosItem>?) {
        this.wallpaper= (wallpaper as ArrayList<PhotosItem>)!!
    }
}