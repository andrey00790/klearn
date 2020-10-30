package com.examples.io

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.FileSystems
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

class NioExamples3 {
    private val path = FileSystems.getDefault().getPath(NioExamples.uri.path)
    private val offset = AtomicLong(0)
    private val step = 10L

    fun readFile(){
        val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2)

        (0..10).forEach { i ->
            executor.execute {
                FileChannel.open(path).use {
                    val buf = ByteBuffer.allocate(10)

                    while (it.read(buf, offset.getAndAdd(step)) > 0) {
                        buf.rewind();
                        print(Charsets.UTF_8.decode(buf));
                        buf.flip();
                    }
                }
            }
        }
        executor.shutdown()
    }
}

fun main(args: Array<String>) {
    NioExamples3().readFile()
}

