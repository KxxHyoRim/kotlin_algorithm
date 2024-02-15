package beakjoon.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

lateinit var fac: IntArray
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    fac = IntArray(n + 1)

    if (n == 1 || n == 2) {
        println(n)
        exitProcess(0)
    }


    fac[1] = 1
    fac[2] = 2

    for (i in 3..n) {
        fac[i] = (fac[i - 1] + fac[i - 2]) % 10_007
    }
    println(fac[n])
}
