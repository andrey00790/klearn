package com.examples.io

import java.nio.ByteBuffer
import java.nio.CharBuffer
import java.nio.channels.FileChannel
import java.nio.file.FileSystems

object NioExamples {
    val uri = this.javaClass.getResource("/hello.txt").toURI()

    fun readFile() {
        val fileSystems = FileSystems.getDefault()

        val path = fileSystems.getPath(uri.path)

        val charBuffer = CharBuffer.allocate(64 * 1024)
        val decoder = Charsets.UTF_8.newDecoder()

        FileChannel.open(path).use {
            val buffer = ByteBuffer.allocate(1024)

            var done = false

            while (!done) {
                buffer.clear()

                done = (it.read(buffer) == -1)

                buffer.flip()
                decoder.decode(buffer, charBuffer, done)

            }

            charBuffer.flip()
        }

        println(charBuffer)
    }

}

fun main() {
    NioExamples.readFile()
}
