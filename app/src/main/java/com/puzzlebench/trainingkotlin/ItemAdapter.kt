package com.puzzlebench.trainingkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_item.view.*


class ItemAdapter(val items: List<Item>, val listener: (Item)-> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.view_item,parent,false)
        return ViewHolder(v)
    }
    // with(holder.itemView) funcion de extencion que recieve una fucnion de extencion en el parametro
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =with(holder.itemView) {
        val item = items[position]
        item_title.text = item.title
        item_image.loadUrl(item.url)
        setOnClickListener { listener(item) }

    }

    override fun getItemCount() = items.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)


}