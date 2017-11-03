package com.puzzlebench.trainingkotlin.data

import com.puzzlebench.trainingkotlin.Item
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

object ItemProvider {
    private val BASE_CITY_NAME = "City"
    private val BASE_IMAGE_URL = "http://lorempixel.com/400/400/city/"
    private var data = emptyList<Item>()
    fun dataAsyc(callback: (List<Item>) -> Unit) {

        doAsync {
            if (data.isEmpty()) {
                Thread.sleep(2000)
                val videoItems = (1..5).map { Item(it.toLong(), "$BASE_CITY_NAME$it", "$BASE_IMAGE_URL$it", Item.Type.VIDEO) }
                val videoPhotos = (6..10).map { Item(it.toLong(), "$BASE_CITY_NAME$it", "$BASE_IMAGE_URL$it", Item.Type.PHOTO) }
                data = (videoPhotos + videoItems).sortedBy { it.id }//by defaul return a inmutable list if we need a mutable list we cant use .toMutableList()
            }

            uiThread {
                callback(data)
            }
        }


    }


}

