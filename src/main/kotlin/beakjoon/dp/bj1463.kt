package beakjoon.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val dp = IntArray(1_000_001) { Int.MAX_VALUE }

    dp[1] = 0
    dp[2] = 1
    dp[3] = 1

    for (i in 4..n) {
        val case1 = if (i % 3 == 0) dp[i / 3] + 1 else Int.MAX_VALUE
        val case2 = if (i % 2 == 0) dp[i / 2] + 1 else Int.MAX_VALUE
        val case3 = dp[i - 1] + 1
        dp[i] = minOf(minOf(case1, case2), case3)
    }

    bw.write("${dp[n]}")
    bw.flush()
}