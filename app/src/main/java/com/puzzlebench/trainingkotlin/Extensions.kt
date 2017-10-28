package com.puzzlebench.trainingkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}

// eg: extension function
fun Context.showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
// eg: extension function
fun RecyclerView.ViewHolder.showToast(message: String) = itemView.context.showToast(message)
