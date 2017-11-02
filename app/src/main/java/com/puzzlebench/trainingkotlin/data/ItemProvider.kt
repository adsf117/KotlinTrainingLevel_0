package com.puzzlebench.trainingkotlin.data

import com.puzzlebench.trainingkotlin.Item

object ItemProvider {

    val BASE_CITY_NAME = "City"
    val BASE_IMAGE_URL = "http://lorempixel.com/400/400/city/"

    val videoItems = (1..5).map { Item(it.toLong(), "$BASE_CITY_NAME$it", "$BASE_IMAGE_URL$it", Item.Type.VIDEO) }
    val videoPhotos = (6..10).map { Item(it.toLong(), "$BASE_CITY_NAME$it", "$BASE_IMAGE_URL$it", Item.Type.PHOTO) }

    val data = (videoPhotos + videoItems).sortedBy { it.id }//by defaul return a inmutable list if we need a mutable list we cant use .toMutableList()

}

