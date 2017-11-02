package com.puzzlebench.trainingkotlin

fun test (items: List<Item>){
    var sum1 = 7.addition(9)
    var suminFix = 7 additionInFix 9
}

fun Int.addition(anyNumber: Int) =this + anyNumber

infix fun Int.additionInFix(anyNumber: Int) =this + anyNumber