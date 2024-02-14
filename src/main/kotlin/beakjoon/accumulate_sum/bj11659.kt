package beakjoon.accumulate_sum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val array = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val ac = IntArray(n + 1) { 0 } // ac[i] = 0부터 i까지의 합
    var sum = 0

    for (i in 0 until n) {
        sum += array[i]
        ac[i + 1] = sum
    }

    repeat(m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${ac[end] - ac[start - 1]}\n")
    }

    bw.flush()

}