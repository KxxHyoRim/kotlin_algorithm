package programmers.kakao22

// 2022 KAKAO TECH INTERNSHIP
// 성격유형 검사하기 (LV1)
// https://school.programmers.co.kr/learn/challenges?order=recent&partIds=31236
class Solution {
    private val map: LinkedHashMap<Char, Int> = linkedMapOf(
        'R' to 0, 'T' to 0, 'C' to 0, 'F' to 0,
        'J' to 0, 'M' to 0, 'A' to 0, 'N' to 0
    )

    fun solution(survey: Array<String>, choices: IntArray): String {


        repeat(survey.size) {
            val personality1 = survey[it][0]
            val personality2 = survey[it][1]
            when (choices[it]) {
                in 1..3 -> {
                    val score = requireNotNull(map[personality1])
                    map[personality1] = score + when (choices[it]) {
                        1 -> 3
                        2 -> 2
                        3 -> 1
                        else -> throw IllegalStateException()
                    }
                }

                in 5..7 -> {
                    val score = requireNotNull(map[personality2])
                    map[personality2] = score + when (choices[it]) {
                        5 -> 1
                        6 -> 2
                        7 -> 3
                        else -> throw IllegalStateException()
                    }
                }
            }
        }
        return getMBTI()
    }

    private fun getMBTI(): String {
        val r = requireNotNull(map['R'])
        val t = requireNotNull(map['T'])
        val c = requireNotNull(map['C'])
        val f = requireNotNull(map['F'])
        val j = requireNotNull(map['J'])
        val m = requireNotNull(map['M'])
        val a = requireNotNull(map['A'])
        val n = requireNotNull(map['N'])

        return buildString {
            if (r >= t) append("R") else append("T")
            if (c >= f) append("C") else append("F")
            if (j >= m) append("J") else append("M")
            if (a >= n) append("A") else append("N")
        }
    }
}

fun main() {
    println(
        Solution().solution(
            survey = arrayOf("AN", "CF", "MJ", "RT", "NA"),
            choices = intArrayOf(5, 3, 2, 7, 5)
        )
    ) // TCMA
    println(
        Solution().solution(
            survey = arrayOf("TR", "RT", "TR"),
            choices = intArrayOf(7, 1, 3)
        )
    ) // RCJA
}