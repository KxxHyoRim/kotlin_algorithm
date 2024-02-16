package beakjoon.greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val str = br.readLine()

    // 숫자 하나만 있는 경우
    if (!str.contains("-") && !str.contains("+")) {
        println(str)
        exitProcess(0)
    }
    val queue = LinkedList<Any>()

    for (i in str) {
        when (i) {
            '+', '-' -> {
                queue.add(sb.toString().toInt())
                queue.add(i.toString())
                sb.clear()
            }

            else -> sb.append(i)
        }
    }
    queue.add(sb.toString().toInt())

    var canConvertMinus = false

    var sum: Int = queue.pollFirst() as Int

    while (queue.isNotEmpty()) {
        val op = queue.pollFirst() as String
        val num = queue.pollFirst() as Int

        when (op) {
            "-" -> {
                sum -= num
                canConvertMinus = true
            }

            "+" -> {
                if (canConvertMinus) sum -= num else sum += num
            }
        }
    }

    println(sum)
}