package beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n: Int = br.readLine().toInt()
    val pq = PriorityQueue(compareBy<Problem> { it.deadLine }.thenByDescending { it.noodle })
    repeat(n) {
        val (n1, n2) = br.readLine().split(" ").map(String::toInt)
        pq.add(Problem(n1, n2))
    }

    val minHeap = PriorityQueue<Int>()

    while (pq.isNotEmpty()) {
        val problem = pq.poll()
        minHeap.add(problem.noodle)
        if (cannotSolveMore(minHeap.size, problem.deadLine)) {
            minHeap.poll()
        }
    }

    bw.write("${minHeap.sum()}")
    bw.flush()
}

fun cannotSolveMore(solvedCount: Int, deadLine: Int): Boolean = solvedCount > deadLine

data class Problem(
    val deadLine: Int, val noodle: Int
)