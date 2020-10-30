package com.examples.io

import java.nio.ByteBuffer
import java.nio.CharBuffer
import java.nio.channels.FileChannel
import java.nio.file.FileSystems
import java.nio.file.StandardOpenOption

object NioExamples2 {
    private val uri = this.javaClass.getResource("/hello.txt").toURI()

    fun readFile() {
        val fileSystems = FileSystems.getDefault()

        val path = fileSystems.getPath(NioExamples.uri.path)
        val charBuffer = CharBuffer.allocate(64 * 1024)
        val decoder = Charsets.UTF_8.newDecoder()

        FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE).use {
           val mappedBuf =  it.map(FileChannel.MapMode.READ_WRITE, 0, it.size())


            println(Charsets.UTF_8.decode(mappedBuf))
        }


    }

}

fun main() {
    NioExamples2.readFile()
}
