package beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

@Suppress("DuplicatedCode")
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val (n: Int, m: Int) = br.readLine().split(" ").map { it.toInt() }
    // val (n: Int, m: Int) = br.readLine().split(" ").map(String::toInt)
    // 위랑 같은 표현 (컴파일 후 성능차이 없음), 하단 표현 방식이 보다 권장 됨
    val intMap = HashMap<Int, String>(n + 1)
    val stringMap = HashMap<String, Int>(n + 1)
    repeat(n) { i ->
        val pokemon = br.readLine()
        intMap[i + 1] = pokemon
        stringMap[pokemon] = i + 1
    }

    repeat(m) {
        val input = br.readLine()
        val result = if (input[0].isDigit()) intMap[input.toInt()] else stringMap[input]
        sb.append("$result\n")
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}