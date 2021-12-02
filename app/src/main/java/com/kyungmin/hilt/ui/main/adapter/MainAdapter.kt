package com.kyungmin.hilt.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyungmin.hilt.R
import com.kyungmin.hilt.data.model.Items


class MainAdapter(
    private val photos: ArrayList<Items>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val image = itemview.findViewById<ImageView>(R.id.image)
        fun bind(items: Items) {
            var imageItem = items.urls.small
            image?.let { Glide.with(it.context).load(imageItem).into(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rec_item_layout, parent, false)
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(photos[position])

    override fun getItemCount(): Int = photos.size

    fun addData(list: ArrayList<Items>) {
        photos.addAll(list)
    }

}