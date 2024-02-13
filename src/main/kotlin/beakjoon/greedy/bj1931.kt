package beakjoon.greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) { it ->
        val (start, end) = br.readLine().split(" ").map {
            it.toInt()
        }
        list.add(it, start to end)
    }
    list.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

    var count = 0
    var lastMeetingEnd = 0

    for (time in list) {
        val start = time.first
        val end = time.second
        if ((start == end) || (start >= lastMeetingEnd)) {
            count++
            lastMeetingEnd = end
        }
    }
    println(count)
}

// 참고자료
// 문제풀이과정 시각화 blog : https://st-lab.tistory.com/145
// Activity Selection Problem (Wikipedia) : https://en.wikipedia.org/wiki/Activity_selection_problem