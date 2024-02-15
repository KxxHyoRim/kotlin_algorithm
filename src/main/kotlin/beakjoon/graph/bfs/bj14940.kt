package beakjoon.graph.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val dx = listOf(0, 0, -1, 1)
val dy = listOf(-1, 1, 0, 0)
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    val dist = Array(n) { IntArray(m) { -1 } }

    var sx: Int = -1
    var sy: Int = -1

    for (y in 0 until n) {
        map[y] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for (x in 0 until m) {
            when (map[y][x]) {
                2 -> {
                    sx = x; sy = y
                }

                0 -> {
                    dist[y][x] = 0
                }
            }
        }
    }

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(sx to sy)
    dist[sy][sx] = 0

    while (queue.isNotEmpty()) {
        val x = queue.peek().first
        val y = queue.peek().second
        queue.removeFirst() // remove랑 같은듯


        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue

            if (map[ny][nx] != 0 && dist[ny][nx] == -1) {
                queue.add(nx to ny)
                dist[ny][nx] = dist[y][x] + 1
            }
        }
    }


    repeat(n) { y ->
        repeat(m) { x ->
            bw.write("${dist[y][x]} ")
        }
        bw.write("\n")
    }
    bw.flush()
}