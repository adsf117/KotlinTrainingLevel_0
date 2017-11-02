package com.puzzlebench.trainingkotlin.data

import com.puzzlebench.trainingkotlin.Item

fun getVideoItems(): List<Item> =//Rangos (1..5) manjeo de numeros secuenciales
        (1..5).map { Item(it.toLong(), "City $it", "http://lorempixel.com/400/400/city/$it/", Item.Type.VIDEO) }

fun getPhotoItems(): List<Item> = (5..10).map { Item(it.toLong(), "City $it", "http://lorempixel.com/400/400/city/$it/", Item.Type.PHOTO) }

fun getItems(): List<Item> =
        (getPhotoItems() + getVideoItems()).sortedBy { it.id }//by defaul return a inmutable list if we need a mutable list we cant use .toMutableList()
