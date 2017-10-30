package com.puzzlebench.trainingkotlin

data class Item(val id: Long, val title: String, val url: String, val type: Type) {
    enum class Type { PHOTO, VIDEO }
}
