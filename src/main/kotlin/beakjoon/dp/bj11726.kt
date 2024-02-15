package beakjoon.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

lateinit var fac: IntArray

fun getFactorial(n: Int) {
    // 최대 n까지 필요함
    fac[0] = 1
    fac[1] = 1

    for (i in 2..n) {
        fac[i] = (fac[i - 1] * i)// % 10_007
    }
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    fac = IntArray(n + 1)

    if (n == 1 || n == 2) {
        println(n)
        exitProcess(0)
    }

    getFactorial(n)

    val max = n / 2
    var sum = 0

    for (horizontal in max downTo 0) {
        val vertical = n - (2 * horizontal)

        val dividend = fac[horizontal + vertical] // 분모
        val divisor = when {
            fac[horizontal] == 0 -> fac[vertical]
            fac[vertical] == 0 -> fac[horizontal]
            else -> (fac[horizontal] * fac[vertical])// % 10_007
        }
        val add = dividend / divisor
        sum += add

    }
    println(sum)
}
