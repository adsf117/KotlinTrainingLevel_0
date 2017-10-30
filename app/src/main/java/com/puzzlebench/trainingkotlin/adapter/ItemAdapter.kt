package com.puzzlebench.trainingkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.puzzlebench.trainingkotlin.R
import com.puzzlebench.trainingkotlin.Item
import com.puzzlebench.trainingkotlin.Item.Type
import com.puzzlebench.trainingkotlin.extension.findTypeById
import com.puzzlebench.trainingkotlin.extension.getImageByUrl
import com.puzzlebench.trainingkotlin.extension.inflate
import com.puzzlebench.trainingkotlin.extension.showToast
import kotlinx.android.synthetic.main.view_item.view.*


class ItemAdapter(val items: List<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = parent.inflate(R.layout.view_item)
        return ViewHolder(v)
    }

    // with(holder.itemView) funcion de extencion que recieve una fucnion de extencion en el parametro
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.itemView) {
        val item = items[position]
        val item_title = findTypeById<TextView>(R.id.item_title) //this is unnecessary becaue de Kotlink androi extention do it but  is just to show how implement a reified function extension
        item_title.text = item.title
        item_image.getImageByUrl(item.url)
        holder.showToast("Loading ${item.title}")
        item_media_video_indicator.visibility = when (item.type) {
            Type.PHOTO -> View.GONE
            Type.VIDEO -> View.VISIBLE
        }
        setOnClickListener { listener(item) }

    }

    override fun getItemCount() = items.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)


}