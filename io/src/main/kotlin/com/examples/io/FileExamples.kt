package com.examples.io


import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths


object FileExamples {
    val uri = this.javaClass.getResource("/hello.txt").toURI()

    fun readFileFromWay1() {
        Files.readAllLines(Paths.get(uri), Charset.defaultCharset())
            .also { println(it) }
    }

    fun readFileFromWay2(){
        File(uri.path).forEachLine { println(it) }
    }

}

fun main() {
    FileExamples.readFileFromWay1()
    FileExamples.readFileFromWay2()
}
