package beakjoon.implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val array2 = Array(100) { Array(100) { false } }
    var sum = 0


    repeat(n) {
        val (X, Y) = br.readLine().split(" ").map { it.toInt() }
        for (j in Y until Y + 10) {
            for (i in X until X + 10) {
                array2[j][i] = true
            }
        }
    }

    for (y in 0 until 100) {
        for (x in 0 until 100) {
            if (array2[y][x]) sum++
        }
    }

    println(sum)

}