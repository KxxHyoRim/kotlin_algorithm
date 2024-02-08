package beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.system.measureTimeMillis

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val (plus, sub, mul, div) = br.readLine().split(" ").map(String::toInt)
    val op = mutableListOf<String>().apply {
        repeat(plus) { add("+") }
        repeat(sub) { add("-") }
        repeat(mul) { add("*") }
        repeat(div) { add("/") }
    }

    lateinit var permutationList: List<List<String>>

    println(
        measureTimeMillis {
            permutationList = permutation(op)
        }
    )

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (operations in permutationList) {
        var result = arr[0]
        for (j in 0 until n - 1) {
            when (operations[j]) {
                "+" -> result += arr[j + 1]
                "-" -> result -= arr[j + 1]
                "*" -> result *= arr[j + 1]
                "/" -> result /= arr[j + 1]
            }
        }
        if (result < min) min = result
        if (result > max) max = result
    }


    val result = buildString {
        append("$max\n$min")
    }
    println(result)
}

fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> {
    return if (sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(el, fin + it, sub - it) }
}
