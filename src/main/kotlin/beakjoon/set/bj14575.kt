package beakjoon.set

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine()

    val list = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val hashset = list.toHashSet().sorted().toList()
    val hashMap = linkedMapOf<Int, Int>()
    hashset.mapIndexed { idx, value ->
        hashMap[value] = idx
    }

    list.map {
        bw.write("${hashMap[it]} ")
    }
    bw.flush()
}