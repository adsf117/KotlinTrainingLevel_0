package com.puzzlebench.trainingkotlin

fun getItems(): List<Item>{
    //Rangos (1..10) manjeo de numeros secuenciales
    return (1..10).map { Item(it.toLong(),"Title $it", "http://lorempixel.com/400/400/cats/$it/") }
}

class Item(val id: Long, val title: String, val url: String)
