package com.examples.stack

class Stack<T>{
    private val list: MutableList<T> = ArrayList<T>()

    fun push(t: T){
        list.add(t)
    }

    fun pop(): T? = list.removeLastOrNull()
}

fun main() {
    val intStack = Stack<Int>()
    intStack.push(10)
    intStack.push(20)

    println(intStack.pop())

    val stringStack = Stack<String>()
    stringStack.push("hello")
    stringStack.push("world")

    println(stringStack.pop())
}
