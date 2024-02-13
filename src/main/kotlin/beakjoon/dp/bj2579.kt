package beakjoon.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

lateinit var stairs: IntArray
lateinit var dp: IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    stairs = IntArray(n + 1)
    dp = IntArray(n + 1) { 0 }
    repeat(n) {
        stairs[it + 1] = br.readLine().toInt()
    }

    when (n) {
        1 -> {
            println(stairs[1])
            exitProcess(0)
        }

        2 -> {
            println(stairs[1] + stairs[2])
            exitProcess(0)
        }

        else -> {
            dp[1] = stairs[1]
            dp[2] = stairs[1] + stairs[2]
        }
    }

    for (i in 3..n) {
        dp[i] = maxOf(dp[i - 2], stairs[i - 1] + dp[i - 3]) + stairs[i]
    }

    println(dp[n])
}

