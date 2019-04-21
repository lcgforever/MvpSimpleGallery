package com.chenguangliu.android.mvpsimplegallery.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chenguangliu.android.mvpsimplegallery.R
import com.chenguangliu.android.mvpsimplegallery.network.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_fragment_photo_item_layout.view.*

/**
 * View adapter class for main fragment photo item
 */
class MainFragmentPhotoAdapter(
    private val context: Context,
    private var photoList: List<Photo>
) : RecyclerView.Adapter<MainFragmentPhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.main_fragment_photo_item_layout, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    fun updatePhotoList(photoList: List<Photo>) {
        this.photoList = photoList.toList()
        notifyDataSetChanged()
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photo: Photo) {
            Picasso.get()
                .load(photo.getUrl())
                .into(itemView.photoItemImageView)
        }
    }
}
