package beakjoon.greedy


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

var ans = 0
lateinit var v: MutableList<Int>
fun removeSet3(i: Int) {
    val n = min(v[i], min(v[i + 1], v[i + 2]))
    ans += 7 * n
    v[i] -= n
    v[i + 1] -= n
    v[i + 2] -= n
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    v = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    v.add(0)
    v.add(0)


    for (i in 0 until n) {

        when {
            (v[i + 1] > v[i + 2]) -> {
                val cnt = min(v[i], v[i + 1] - v[i + 2])
                ans += 5 * cnt
                v[i] -= cnt
                v[i + 1] -= cnt
                removeSet3(i)
            }

            else -> {
                removeSet3(i)
                val cnt = min(v[i], v[i + 1])
                ans += 5 * cnt
                v[i] -= cnt
                v[i + 1] -= cnt
            }
        }
        ans += 3 * v[i]

    }
    println(ans)
}