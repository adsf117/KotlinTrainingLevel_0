package com.puzzlebench.trainingkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.puzzlebench.trainingkotlin.R
import com.puzzlebench.trainingkotlin.data.Item
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
        item_title.text = item.title
        item_image.getImageByUrl(item.url)
        holder.showToast("Loading ${item.title}")
        setOnClickListener { listener(item) }

    }

    override fun getItemCount() = items.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)


}