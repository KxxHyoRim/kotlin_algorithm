package notion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 문자열 입력
    val string = br.readLine()
    // 정수 입력
    val int = br.readLine().toInt()
    // split 활용
    val (n, m) = br.readLine().split(' ').map {
        it.toInt()
    }
    println("$string, $int, $n, $m")

    // 입력과 repeat 접목
    repeat(br.readLine().toInt()) {
        println("repeat")
    }

    // 이차원 배열 입력
    val arr2 = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    println(arr2[0][0])

    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("test")
    bw.flush()
    bw.close()
}