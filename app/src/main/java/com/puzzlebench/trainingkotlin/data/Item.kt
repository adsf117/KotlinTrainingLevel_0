package com.puzzlebench.trainingkotlin.data

fun getItems(): List<Item>{
    //Rangos (1..10) manjeo de numeros secuenciales
    return (1..10).map { Item(it.toLong(), "City $it", "http://lorempixel.com/400/400/city/$it/") }
}

class Item(val id: Long, val title: String, val url: String)
