package beakjoon.graph.bfs

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val isVisited = BooleanArray(n + 1) { false }
    val parent = IntArray(n + 1)

    repeat(n - 1) {
        val (n1, n2) = br.readLine().split(" ").map { it.toInt() }
        graph[n1].add(n2)
        graph[n2].add(n1)
    }

    // bfs

    val queue = ArrayDeque<Int>()
    isVisited[1] = true
    for (node in graph[1]) {
        queue.add(node)
        parent[node] = 1
    }
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        isVisited[node] = true

        for (child in graph[node]) {
            if (isVisited[child]) continue
            queue.add(child)
            parent[child] = node
        }
    }

    for (i in 2..n) {
        println(parent[i])
    }
}