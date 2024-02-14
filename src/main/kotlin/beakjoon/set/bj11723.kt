package beakjoon.set

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 시간 복잡도 개선하려면 set 자료구조 대신 bit masking 할 수 있음
// 메모리는 거의 비슷한것같고, 속도 300ms 정도 차이남
// s = 0b11111_11111_11111_11111


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val set = hashSetOf<Int>()
    val n = br.readLine().toInt()

    repeat(n) {
        val oneLine = br.readLine()

        val (op, numString) = when {
            oneLine.contains(" ") -> oneLine.split(" ")
            else -> listOf(oneLine, null)
        }

        // 단어가 2개가 들어올지, 1개가 들어올지 모르는 상황에서 아래와 같이 하는것도 가능!
        // val command = br.readLine().split(" ")
        // when (command[0]) { }

        val num = numString?.toInt()

        when (op) {
            "add" -> {
                set.add(requireNotNull(num))
            }

            "remove" -> {
                set.remove(num)
            }

            "check" -> {
                val string = if (set.contains(num)) "1" else "0"
                bw.write("$string\n")
            }

            "toggle" -> {
                if (set.contains(num)) set.remove(num) else set.add(requireNotNull(num))
            }

            "all" -> {
                set.clear()
                set.addAll(1..20)
            }

            "empty" -> {
                set.clear()
            }
        }

    }

    bw.flush()

}