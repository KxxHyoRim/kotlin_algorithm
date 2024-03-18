package programmers.kakao20

class Solution {

    private var answer = ""
    private var leftPos = "*"
    private var rightPos = "#"
    private lateinit var handed: String

    private val leftMap = mutableMapOf(
        Pair("1", "2") to 1,
        Pair("1", "5") to 2,
        Pair("1", "8") to 3,
        Pair("1", "0") to 4,

        Pair("4", "2") to 2,
        Pair("4", "5") to 1,
        Pair("4", "8") to 2,
        Pair("4", "0") to 3,

        Pair("7", "2") to 3,
        Pair("7", "5") to 2,
        Pair("7", "8") to 1,
        Pair("7", "0") to 2,

        Pair("*", "2") to 4,
        Pair("*", "5") to 3,
        Pair("*", "8") to 2,
        Pair("*", "0") to 1,

        Pair("2", "2") to 0,
        Pair("2", "5") to 1,
        Pair("2", "8") to 2,
        Pair("2", "0") to 3,
        Pair("5", "2") to 1,
        Pair("5", "5") to 0,
        Pair("5", "8") to 1,
        Pair("5", "0") to 2,
        Pair("8", "2") to 2,
        Pair("8", "5") to 1,
        Pair("8", "8") to 0,
        Pair("8", "0") to 1,
        Pair("0", "2") to 3,
        Pair("0", "5") to 2,
        Pair("0", "8") to 1,
        Pair("0", "0") to 1,

        )
    private val rightMap = mutableMapOf(
        Pair("3", "2") to 1,
        Pair("3", "5") to 2,
        Pair("3", "8") to 3,
        Pair("3", "0") to 4,

        Pair("6", "2") to 2,
        Pair("6", "5") to 1,
        Pair("6", "8") to 2,
        Pair("6", "0") to 3,

        Pair("9", "2") to 3,
        Pair("9", "5") to 2,
        Pair("9", "8") to 1,
        Pair("9", "0") to 2,

        Pair("#", "2") to 4,
        Pair("#", "5") to 3,
        Pair("#", "8") to 2,
        Pair("#", "0") to 1,
        Pair("2", "2") to 0,
        Pair("2", "5") to 1,
        Pair("2", "8") to 2,
        Pair("2", "0") to 3,
        Pair("5", "2") to 1,
        Pair("5", "5") to 0,
        Pair("5", "8") to 1,
        Pair("5", "0") to 2,
        Pair("8", "2") to 2,
        Pair("8", "5") to 1,
        Pair("8", "8") to 0,
        Pair("8", "0") to 1,
        Pair("0", "2") to 3,
        Pair("0", "5") to 2,
        Pair("0", "8") to 1,
        Pair("0", "0") to 1,

        )

    private fun calc(n: String): String {

        val leftCnt = leftMap[Pair(leftPos, n)] ?: throw IllegalStateException()
        val rightCnt = rightMap[Pair(rightPos, n)] ?: throw IllegalStateException()

        return when {
            leftCnt < rightCnt -> "L"
            leftCnt > rightCnt -> "R"
            else -> handed
        }

    }

    fun solution(numbers: IntArray, hand: String): String {

        handed = when (hand) {
            "right" -> "R"
            "left" -> "L"
            else -> ""
        }
        for (n in numbers) {
            answer += when (n) {
                1, 4, 7 -> {
                    leftPos = n.toString()
                    "L"
                }

                3, 6, 9 -> {
                    rightPos = n.toString()
                    "R"
                }

                else -> {
                    val direction = calc(n.toString())
                    when (direction) {
                        "L" -> leftPos = n.toString()
                        "R" -> rightPos = n.toString()
                        else -> {}
                    }
                    direction
                }
            }
        }
        println(answer)
        answer = ""
        return answer
    }
}

fun main() {
    val s = Solution()
    s.solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right")
    s.solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left")
    s.solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right")
}