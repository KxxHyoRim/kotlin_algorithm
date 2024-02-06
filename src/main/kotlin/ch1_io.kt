import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    val int = br.readLine().toInt()

    val (n, m) = br.readLine().split(' ').map {
        it.toInt()
    }

    println("$string, $int, $n, $m")

    repeat(br.readLine().toInt()) {
        println("repeat")
    }

    val arr2 = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    println(arr2[0][0])
}