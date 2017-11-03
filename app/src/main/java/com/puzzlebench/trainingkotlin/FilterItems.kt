package com.puzzlebench.trainingkotlin

sealed class FilterItems {
    object None : FilterItems() // we use a object because dont have state
    class ByType(val type: Item.Type) : FilterItems()
}
