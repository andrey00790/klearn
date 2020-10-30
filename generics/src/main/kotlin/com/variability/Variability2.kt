package com.variability




abstract class Source<out T> {
    abstract fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // Всё в порядке, т.к. T — out-параметр
    // ...
}

fun copy(from: Array<out Any>, to: Array<in Any>) {
    // ...
}

fun main() {

}
