package com.examples.io

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter


object WriteIoExamples {

    fun writeTextWay1(text: String){
        BufferedOutputStream(FileOutputStream(File("/Users/a.kotenev/work_projects/klearn/io/src/main/resources/writeFile1.txt"))).use {
            it.write(text.toByteArray())
        }
    }

    fun writeTextWay2(text: String){
        FileWriter(File("/Users/a.kotenev/work_projects/klearn/io/src/main/resources/writeFile2.txt")).use {
            it.write(text)
        }
    }
}

fun main() {
    WriteIoExamples.writeTextWay1("hello, world !")

    WriteIoExamples.writeTextWay2("hello, world !")
}
