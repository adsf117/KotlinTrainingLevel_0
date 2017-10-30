package com.puzzlebench.trainingkotlin.data

import com.puzzlebench.trainingkotlin.Item

fun getVideoItems(): List<Item> =//Rangos (1..10) manjeo de numeros secuenciales
        (1..5).map { Item(it.toLong(), "City $it", "http://lorempixel.com/400/400/city/$it/", Item.Type.VIDEO) }

fun getPhotoItems(): List<Item> =//Rangos (1..10) manjeo de numeros secuenciales
        (5..10).map { Item(it.toLong(), "City $it", "http://lorempixel.com/400/400/city/$it/", Item.Type.PHOTO) }

fun getItems(): List<Item> = getVideoItems() + getPhotoItems()
