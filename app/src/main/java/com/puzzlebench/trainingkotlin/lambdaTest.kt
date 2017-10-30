package com.puzzlebench.trainingkotlin

interface Callback {
    fun Callback(result: String)
}

fun doAsync(x: Int, callback: Callback) {
    callback.Callback("done")
}

fun test() {
    doAsync(20, object : Callback {
        override fun Callback(result: String) {
            print(result)
        }
    })
    doAsyncLambda(20, {result -> print(result)}) //if we use a lambda is not necesary add a callback interface
}

fun doAsyncLambda(x: Int, callback: (String) -> Unit) {
    callback("done")

}