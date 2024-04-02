package programmers.kakao19

import kotlin.math.pow

class Candidate {
    fun solution(relation: Array<Array<String>>): Int {

        val row = relation.size
        val column = relation[0].size
        val combinationNum = 2.0.pow(column).toInt()

        // 후보키 목록 뽑은 다음 size가 작은것부터 정렬
        val sortedNumbers = (1 until combinationNum)
            .sortedBy { Integer.bitCount(it) }

        val candidates = mutableListOf<Int>()

        for (number in sortedNumbers) {
            // 최소성 검사
            var isPossible = true
            for (candidate in candidates) {
                if ((number and candidate) == candidate) {
                    isPossible = false
                    break
                }
            }
            if (!isPossible) continue


            val set = hashSetOf<String>() // 유일성 검사

            for (i in 0 until row) { // 가로 한줄씩 검사
                val r = relation[i]
                var string = ""
                val binary = number.toString(2).padStart(column, '0') // 2진수 변환 string
                binary.mapIndexed { idx, it ->
                    if (it == '1') string += r[idx]
                }
                if (set.contains(string)) {
                    break
                } else {
                    set.add(string)
                }
            }
            if (set.size == row) {
                println(number)
                candidates.add(number)
            }
        }
        println(candidates.size)
        return candidates.size
    }
}

fun main() {

    val relation =
        arrayOf(
            arrayOf("100", "ryan", "music", "2", "0"),
            arrayOf("200", "apeach", "math", "2", "1"),
            arrayOf("300", "tube", "computer", "3", "2"),
            arrayOf("400", "con", "computer", "4", "3"),
            arrayOf("500", "muzi", "music", "3", "4"),
            arrayOf("600", "apeach", "music", "2", "5")
        )
    Candidate().solution(relation)
}