package com.puzzlebench.trainingkotlin

fun test (items: List<Item>){
    var sum1 = 7.addition(9)
    var suminFix = 7 additionInFix 9

    var pair = Pair(7,"Day")
    var pairInFix = 7 to "Day"//I dont like this, 7 to "Day" to 4 to 8 to ....n
}

fun Int.addition(anyNumber: Int) =this + anyNumber

infix fun Int.additionInFix(anyNumber: Int) =this + anyNumber