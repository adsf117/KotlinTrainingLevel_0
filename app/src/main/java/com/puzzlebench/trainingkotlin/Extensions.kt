package com.puzzlebench.trainingkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}

// eg: extension function default parameter
fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()

// eg: extension function
fun RecyclerView.ViewHolder.showToast(message: String) = itemView.context.showToast(message)
