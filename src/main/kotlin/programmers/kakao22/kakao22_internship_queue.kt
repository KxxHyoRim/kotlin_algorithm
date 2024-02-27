package programmers.kakao22

import java.lang.Math.min
import kotlin.properties.Delegates

class Solution2 {
    private var length by Delegates.notNull<Int>()
    private var lastQ1Idx by Delegates.notNull<Int>()
    private var firstQ2Idx by Delegates.notNull<Int>()

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val array = queue1 + queue2
        length = queue1.size + queue2.size
        lastQ1Idx = length / 2 - 1
        firstQ2Idx = lastQ1Idx + 1
        val n = length + 1
        val ac = LongArray(n)
        array.foldIndexed(0L) { idx, total, num ->
            ac[idx + 1] = total + num.toLong()
            return@foldIndexed ac[idx + 1]
        }

        // 15
        val sum = ac[n - 1]
        if (sum % 2 != 0L) return -1

        val target = ac[n - 1] / 2
        var start: Int
        var end: Int
        var minMove = Int.MAX_VALUE
        for (i in 0 until n) {
            if (ac[n - 1] - ac[i] < sum / 2) break
            for (j in i + 1 until n) {
                if (ac[j] - ac[i] == target) {
                    start = i
                    end = j - 1
                    minMove = min(minMove, calcMove(start, end))
                }
            }
        }
        return if (minMove == Int.MAX_VALUE) -1 else minMove
    }

    private fun calcMove(start: Int, end: Int): Int {
        var moveCount = 0

        // 목표하는 수가  q1에만 있을떄 -> q2로 다 옮겨야한다
        when {
            (isInQueue1(start) && isInQueue1(end)) -> {
                when {
                    end == lastQ1Idx -> moveCount += start // 앞에 있는것만 이동
                    else -> moveCount += ((end - start + 1) + (length / 2) + start)
                }
            }

            (isInQueue1(start) && !isInQueue1(end)) -> {
                val rtn = end - firstQ2Idx + 1 + start
//                moveCount += (1 +start)
                moveCount += rtn
            }

            else -> when { // q2에만 있는경우
                (end == length - 1) -> moveCount += start - firstQ2Idx
                else -> moveCount += (length / 2) + (end - start + 1) + (start - firstQ2Idx) * 2
            }
        }

        return moveCount
    }

    private fun isInQueue1(idx: Int): Boolean {
        return idx <= lastQ1Idx
    }
}

fun main() {
    check(
        Solution2().solution(
            queue1 = intArrayOf(3, 2, 7, 2),
            queue2 = intArrayOf(4, 6, 5, 1)
        ) == 2
    )
    println()
    check(
        Solution2().solution(
            queue1 = intArrayOf(1, 2, 1, 2),
            queue2 = intArrayOf(1, 10, 1, 2)
        ) == 7
    )
    check(
        Solution2().solution(
            queue1 = intArrayOf(1, 1),
            queue2 = intArrayOf(1, 5)
        ) == -1
    )
    check(
        Solution2().solution(
            queue1 = intArrayOf(9, 7, 2),
            queue2 = intArrayOf(9, 2, 11)
        ) == 3
    )
}